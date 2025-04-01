package com.ai_based_document_summarizer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@Configuration
public class ModelConfig {

    @Value("${djl.model.url}")
    private String modelUrl;

    public String getModelUrl() {
        return modelUrl;
    }
}
