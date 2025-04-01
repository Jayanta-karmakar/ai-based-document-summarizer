package com.ai_based_document_summarizer.repository;

import com.ai_based_document_summarizer.entity.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@Repository
public interface SummaryRepository extends MongoRepository<Summary, String> {

}

