package com.filos.core.entities;


import lombok.Data;

import java.util.Map;

@Data

public class RecipientEntity {
    private String accountName;
    private String email;
    private Map<NotificationType, NotificationSettings> scheduledNotifications;
}
