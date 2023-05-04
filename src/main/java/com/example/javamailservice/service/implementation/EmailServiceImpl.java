package com.example.javamailservice.service.implementation;

import com.example.javamailservice.config.EmailSenderSettings;
import com.example.javamailservice.service.EmailService;
import com.example.javamailservice.controller.request.Email;
import com.example.javamailservice.utils.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailSenderSettings emailSenderSettings;

    private Session createSession() {

        Properties props = new Properties();
        props.put("mail.smtp.host", emailSenderSettings.getHost());
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        emailSenderSettings.getUsername(),
                        emailSenderSettings.getPassword()
                );
            }
        };
        return Session.getInstance(props, auth);
    }

    @Override
    public void sendSimpleEmail(Email email) {
        Session session = createSession();
        EmailUtil.sendEmail(
                session,
                emailSenderSettings.getUsername(),
                email.getRecipient(),
                email.getSubject(),
                email.getBody()
        );
    }

    @Override
    public void sendAttachmentEmail(Email email, MultipartFile file) {
        Session session = createSession();
        EmailUtil.sendAttachmentEmail(
                session,
                emailSenderSettings.getUsername(),
                email.getRecipient(),
                email.getSubject(),
                email.getBody(),
                file
        );
    }

}
