package com.ai_based_document_summarizer.controller;

import com.ai_based_document_summarizer.service.SummarizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@RestController
@RequestMapping("/summarize")
public class SummarizationController {

    private final SummarizationService summarizationService;

    @Autowired
    public SummarizationController(SummarizationService summarizationService) {
        this.summarizationService = summarizationService;
    }

    @PostMapping
    public ResponseEntity<String> summarizeText(@RequestBody String text) {
        return ResponseEntity.ok(summarizationService.summarize(text));
    }
}

