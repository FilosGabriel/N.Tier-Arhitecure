package com.filos.application.services.notifications.impl;

import com.filos.application.models.notification.RecipientModel;
import com.filos.application.services.notifications.NotificationSettingsService;
import com.filos.core.entities.NotificationSettings;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NotificationSettingsServiceImpl implements NotificationSettingsService {
    @Override
    public void updateSettings(RecipientModel recipientModel) {
        recipientModel.getScheduledNotifications()
                .values()
                .forEach(settings -> updateSetting(settings));
    }

    private void updateSetting(NotificationSettings settings) {
        if (settings.getLastNotified() == null) {
            settings.setLastNotified(LocalDate.now());
        }
    }
}
