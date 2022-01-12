package com.filos.application.common.email;

import lombok.Builder;
import lombok.experimental.Accessors;

import java.util.List;

@Builder
public record EmailMessage(
        String toAddress,
        String body,
        String subject,
        List<EmailAttachment> attachment
) {
    public static EmailMessage create(String toAddress, String body, String subject, EmailAttachment attachment) {
        return EmailMessage.builder()
                .toAddress(toAddress)
                .body(body)
                .subject(subject)
                .attachment(List.of(attachment));
    }
}
