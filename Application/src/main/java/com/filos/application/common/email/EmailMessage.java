package com.filos.application.common.email;

import com.filos.application.models.notification.RecipientModel;
import com.filos.core.entities.NotificationType;
import lombok.Builder;

import java.util.List;

@Builder
public record EmailMessage(
        NotificationType type,
        RecipientModel recipient,
        List<EmailAttachment> attachment
) {
}
