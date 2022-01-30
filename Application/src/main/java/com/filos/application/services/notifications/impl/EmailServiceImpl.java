package com.filos.application.services.notifications.impl;

import com.filos.application.common.email.EmailMessage;
import com.filos.application.configuration.email.EmailProperties;
import com.filos.application.services.notifications.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private JavaMailSender mailSender;
    private EmailProperties emailProperties;

    @Override
    public CompletableFuture<Void> sendEmail(EmailMessage emailMessage) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        var email = emailProperties.properties().get(emailMessage.type()).email();

        helper.setTo(emailMessage.recipient().getEmail());
        helper.setSubject(email.subject());
        helper.setText(email.text());
        for (String attachment : email.attachment()) {
            helper.addAttachment(attachment, new ByteArrayResource(attachment.getBytes()));
        }

        return CompletableFuture.runAsync(() -> {
            mailSender.send(message);
            log.info("{} email notification has been send to {}", emailMessage.type(), emailMessage.recipient().getEmail());
        });
    }
}
