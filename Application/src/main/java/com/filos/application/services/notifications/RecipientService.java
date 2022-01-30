package com.filos.application.services.notifications;

import com.filos.application.models.notification.RecipientModel;
import com.filos.core.entities.NotificationType;

import java.util.List;

public interface RecipientService {
    RecipientModel findByAccountName(String name);

    RecipientModel save(String name, RecipientModel recipient);

    List<RecipientModel> findReadyToNotify(NotificationType type);

    void markNotified(NotificationType type, RecipientModel recipient);

}
