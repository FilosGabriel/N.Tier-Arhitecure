package com.filos.application.configuration.email;

import com.filos.core.entities.NotificationType;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.EnumMap;
import java.util.List;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public class EmailProperties {
    private EnumMap<NotificationType, Values> properties;

    @Data
    @Accessors(fluent = true)
    public static class Values {
        private String cron;
        private Email email;

    }

    @Data
    @Accessors(fluent = true)
    public static class Email {
        private String text;
        private String subject;
        private List<String> attachment;
    }
}
