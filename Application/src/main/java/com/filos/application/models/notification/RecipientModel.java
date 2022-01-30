package com.filos.application.models.notification;

import com.filos.core.entities.NotificationSettings;
import com.filos.core.entities.NotificationType;
import lombok.Data;

import java.util.Map;

@Data
public class RecipientModel {
    private String accountName;
    private String email;
    private Map<NotificationType, NotificationSettings> scheduledNotifications;

}
