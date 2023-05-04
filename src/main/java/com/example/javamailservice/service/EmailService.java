package com.example.javamailservice.service;

import com.example.javamailservice.controller.request.Email;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    void sendSimpleEmail(Email email);

    void sendAttachmentEmail(Email email, MultipartFile file);
}
