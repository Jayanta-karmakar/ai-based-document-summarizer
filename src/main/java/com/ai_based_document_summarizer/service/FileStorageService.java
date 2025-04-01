package com.ai_based_document_summarizer.service;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 01/04/25, Tuesday
 **/

@Service
public class FileStorageService {

    public String extractText(MultipartFile file) {
        try (InputStream input = file.getInputStream()) {
            return new Tika().parseToString(input);
        } catch (Exception e) {
            throw new RuntimeException("Error extracting text", e);
        }
    }
}

