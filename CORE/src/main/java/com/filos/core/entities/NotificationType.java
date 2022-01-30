package com.filos.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationType {
    BACKUP("backup.email.subject", "backup.email.text", "backup.email.attachment"),

    REMIND("remind.email.subject", "remind.email.text", null);

    private String subject;
    private String text;
    private String attachment;

}
