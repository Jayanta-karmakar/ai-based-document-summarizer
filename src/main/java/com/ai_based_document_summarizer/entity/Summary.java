package com.ai_based_document_summarizer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@Data
@Document(collection = "summaries")
public class Summary {
    @Id
    private String id;
    private String originalText;
    private String summarizedText;
}

