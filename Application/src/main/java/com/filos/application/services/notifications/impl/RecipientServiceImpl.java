package com.filos.application.services.notifications.impl;

import com.filos.application.models.notification.RecipientModel;
import com.filos.application.services.notifications.NotificationSettingsService;
import com.filos.application.services.notifications.RecipientService;
import com.filos.core.entities.NotificationType;
import com.filos.core.entities.RecipientEntity;
import com.filos.core.exception.EntityNotFound;
import com.filos.dataaccess.repositories.RecipientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
//@Service
@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {
    private final RecipientRepository repository;
    private final ConversionService conversionService;
    private final NotificationSettingsService notificationSettingsService;

    @Override
    public RecipientModel findByAccountName(String name) {
        return repository.findByAccountName(name)
                .map(recipient -> conversionService.convert(recipient, RecipientModel.class))
                .orElseThrow(EntityNotFound::new);
    }

    @Override
    public RecipientModel save(String name, RecipientModel recipientModel) {
        recipientModel.setAccountName(name);
        notificationSettingsService.updateSettings(recipientModel);
        RecipientEntity entity = conversionService.convert(recipientModel, RecipientEntity.class);
        RecipientEntity savedEntity = repository.save(entity);
        return conversionService.convert(savedEntity, RecipientModel.class);
    }

    @Override
    public List<RecipientModel> findReadyToNotify(NotificationType type) {
        List<RecipientEntity> entities = switch (type) {
            case BACKUP -> repository.findReadyForBackup();
            case REMIND -> repository.findReadyForRemind();
            default -> throw new IllegalArgumentException();
        };
        return entities.stream()
                .map(entity -> conversionService.convert(entity, RecipientModel.class))
                .toList();
    }

    @Override
    public void markNotified(NotificationType type, RecipientModel recipient) {
        recipient.getScheduledNotifications().get(type).setLastNotified(LocalDate.now());
        RecipientEntity entity = conversionService.convert(recipient, RecipientEntity.class);
        repository.save(entity);
    }
}
