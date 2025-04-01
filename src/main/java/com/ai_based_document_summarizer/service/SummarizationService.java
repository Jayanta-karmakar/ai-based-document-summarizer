package com.ai_based_document_summarizer.service;

import ai.djl.inference.Predictor;
import ai.djl.ndarray.NDList;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.translate.Batchifier;
import ai.djl.translate.TranslateException;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;
import com.ai_based_document_summarizer.config.ModelConfig;
import com.ai_based_document_summarizer.entity.Summary;
import com.ai_based_document_summarizer.repository.SummaryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@Service
public class SummarizationService {
    private final SummaryRepository summaryRepository;
    @Getter
    private final ModelConfig modelConfig;
    private ZooModel<String, String> model;

    @Autowired
    public SummarizationService(SummaryRepository summaryRepository,
                                ModelConfig modelConfig) {
        this.summaryRepository = summaryRepository;
        this.modelConfig = modelConfig;
        initializeModel();
    }

    private void initializeModel() {
        try {
            Criteria<String, String> criteria = Criteria.builder()
                    .setTypes(String.class, String.class)
                    .optModelUrls(modelConfig.getModelUrl())
                    .optTranslator(new Translator<String, String>() {
                        @Override
                        public String processOutput(TranslatorContext ctx, NDList list) {
                            return null;
                        }

                        @Override
                        public NDList processInput(TranslatorContext ctx, String input) {
                            return new NDList(ctx.getNDManager().create(input));
                        }

                        @Override
                        public Batchifier getBatchifier() {
                            return null;
                        }
                    })
                    .build();
            this.model = ModelZoo.loadModel(criteria);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load model", e);
        }
    }

    public String summarize(String text) {
        try (Predictor<String, String> predictor = model.newPredictor()) {
            String summarizedText = predictor.predict("summarize: " + text);
            // Save the summary to the database
            saveSummary(text, summarizedText);
            return summarizedText;
        } catch (TranslateException e) {
            throw new RuntimeException("Summarization failed", e);
        }
    }

    private void saveSummary(String text, String summarizedText) {
        Summary summary = new Summary();
        summary.setOriginalText(text);
        summary.setSummarizedText(summarizedText);
        summaryRepository.save(summary);
    }
}

