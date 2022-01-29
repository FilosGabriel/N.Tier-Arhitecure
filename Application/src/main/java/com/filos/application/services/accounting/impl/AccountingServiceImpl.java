package com.filos.application.services.accounting.impl;

import com.filos.application.models.account.AccountModel;
import com.filos.application.models.mappers.AccountMapper;
import com.filos.application.models.user.CreateUserModel;
import com.filos.application.services.accounting.AccountingService;
import com.filos.core.entities.AccountEntity;
import com.filos.core.exception.EntityAlreadyExists;
import com.filos.core.exception.EntityNotFound;
import com.filos.dataaccess.repositories.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@Validated
public class AccountingServiceImpl implements AccountingService {
    AccountRepository accountRepository;
    AccountMapper mapper;

    @Override
    public AccountModel findByName(@NotEmpty String accountName) {
        return accountRepository.findByName(accountName)
                .map(mapper::mapToModelI)
                .orElseThrow();
    }

    @Override
    @Transactional
    public AccountModel create(CreateUserModel createUserModel) {
        accountRepository.findByName(createUserModel.getUsername())
                .ifPresent(e -> EntityAlreadyExists.from(e));

        AccountEntity entity = mapper.mapFromCreate(createUserModel);
        accountRepository.save(entity);
        log.info("new account has been created: " + entity.getName());
        return mapper.map(entity);
    }

    @Override
    public void saveChanges(String name, AccountModel update) {
        accountRepository.findByName(name)
                .orElseThrow(EntityNotFound::new);

        AccountEntity entity = mapper.mapFromCreate(update);
        accountRepository.save(entity);
    }
}
