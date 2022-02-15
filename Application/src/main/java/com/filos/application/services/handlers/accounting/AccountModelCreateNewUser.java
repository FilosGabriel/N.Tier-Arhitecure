package com.filos.application.services.handlers.accounting;

import an.awesome.pipelinr.Command;
import com.filos.application.models.account.AccountModel;
import com.filos.application.models.mappers.account.entity.AccountModelMapper;
import com.filos.application.services.commands.AccountingServiceCommands;
import com.filos.core.entities.AccountEntity;
import com.filos.core.exception.EntityAlreadyExists;
import com.filos.dataaccess.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountModelCreateNewUser implements Command.Handler<AccountingServiceCommands.Create, AccountModel> {

    private final AccountRepository accountRepository;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public AccountModel handle(AccountingServiceCommands.Create create) {
        accountRepository.findByName(create.createUserModel().getUsername())
                .ifPresent(e -> EntityAlreadyExists.from(e));

        AccountEntity entity = conversionService.convert(create.createUserModel(), AccountEntity.class);
        accountRepository.save(entity);
        log.info("new account has been created: " + entity.getName());
        return conversionService.convert(entity, AccountModel.class);
    }
}
