package com.filos.application.services.impl;

import com.filos.application.common.email.EmailAttachment;
import com.filos.application.common.email.EmailMessage;
import com.filos.application.configuration.email.SmtpSettings;
import com.filos.application.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.util.concurrent.CompletableFuture;

//@Component
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final SmtpSettings smtpSettings;

    @Override
    public CompletableFuture sendEmail(EmailMessage emailMessage) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);

        emailMessage.attachment().forEach(
                attachment -> addAttachment(mimeMessageHelper, attachment));

        message.setText(emailMessage.body());
        message.setSubject(emailMessage.subject());
        message.setFrom(smtpSettings.getSenderEmail());
        message.addRecipients(MimeMessage.RecipientType.TO, emailMessage.toAddress());

        return CompletableFuture.runAsync(() -> emailSender.send(message));
    }

    @SneakyThrows
    private void addAttachment(MimeMessageHelper mimeMessageHelper, EmailAttachment attachment) {
        mimeMessageHelper.addAttachment(attachment.name(),
                () -> new ByteArrayInputStream(attachment.value()));
    }
}
