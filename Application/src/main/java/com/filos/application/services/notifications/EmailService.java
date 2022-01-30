package com.filos.application.services.notifications;

import com.filos.application.common.email.EmailMessage;

import javax.mail.MessagingException;
import java.util.concurrent.CompletableFuture;

public interface EmailService {

    CompletableFuture<Void> sendEmail(EmailMessage emailMessage) throws MessagingException;
}
