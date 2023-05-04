package com.example.javamailservice.controller;

import com.example.javamailservice.service.EmailService;
import com.example.javamailservice.controller.request.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email")
    private ResponseEntity<String> sendSimpleEmail(
            @RequestBody Email email
    ) {
        emailService.sendSimpleEmail(email);
        return ResponseEntity.ok("Email was sent successfully!");
    }

    @PostMapping("/attachment-email")
    private ResponseEntity<String> sendAttachmentEmail(
            @RequestPart(name = "email") Email email,
            @RequestPart(name = "file") MultipartFile file
    ) {
        if (file != null && file.isEmpty())
            throw new RuntimeException("No valid attachment file provided.");
        long fileSize = file.getSize();
        if (fileSize > 10 * 1024 * 1024) {
            throw new RuntimeException("Maximum attachment file size is 10 MB.");
        }
        emailService.sendAttachmentEmail(email, file);
        return ResponseEntity.ok("Email was sent successfully!");
    }

}
