package com.example.javamailservice.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     *
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(
            Session session,
            String fromEmail,
            String toEmail,
            String subject,
            String body
    ) {
        try {
            MimeMessage msg = createMimeMessage(session, fromEmail, toEmail, subject);
            msg.setContent(body, "text/html; charset=utf-8");
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Utility method to send HTML email with attachment
     *
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     * @param file
     */
    public static void sendAttachmentEmail(
            Session session,
            String fromEmail,
            String toEmail,
            String subject,
            String body,
            MultipartFile file
    ) {
        try {
            MimeMessage msg = createMimeMessage(session, fromEmail, toEmail, subject);

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(body);

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Add attachment
            if (file != null) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();

                attachmentBodyPart.setContent(file.getBytes(), file.getContentType());
                attachmentBodyPart.setFileName(file.getOriginalFilename());
                attachmentBodyPart.setDisposition(Part.ATTACHMENT);

                multipart.addBodyPart(attachmentBodyPart);
            }

            // Send the complete message parts
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);
        } catch (MessagingException | IOException e) {
            e.printStackTrace(System.out);
            throw new RuntimeException("Error sending email with attachment");
        }
    }

    public static MimeMessage createMimeMessage(
            Session session,
            String fromEmail,
            String toEmail,
            String subject
    ) throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

        return msg;
    }
}
