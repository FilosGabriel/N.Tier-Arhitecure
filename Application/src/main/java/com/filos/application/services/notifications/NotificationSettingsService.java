package com.filos.application.services.notifications;

import com.filos.application.models.notification.RecipientModel;

public interface NotificationSettingsService {
    void updateSettings(RecipientModel recipientModel);
}
