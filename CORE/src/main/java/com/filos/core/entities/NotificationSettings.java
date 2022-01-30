package com.filos.core.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotificationSettings {

    private Boolean active;

    private Frequency frequency;

    private LocalDate lastNotified;
}
