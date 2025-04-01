package com.ai_based_document_summarizer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "summaries")
public class Summary {
    @Id
    private String id;
    private String originalText;
    private String summarizedText;
}

