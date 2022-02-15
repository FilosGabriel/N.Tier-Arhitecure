package com.filos.application.services.handlers.accounting;

import an.awesome.pipelinr.Command;
import com.filos.application.models.account.AccountModel;
import com.filos.application.models.mappers.account.entity.AccountModelMapper;
import com.filos.application.models.mappers.account.entity.CreateUserModelMapper;
import com.filos.application.models.user.CreateUserModel;
import com.filos.core.entities.AccountEntity;
import com.filos.core.exception.EntityAlreadyExists;
import com.filos.dataaccess.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountModelCreateNewUser implements Command.Handler<CreateUserModel, AccountModel> {

    private final AccountRepository accountRepository;
    private final CreateUserModelMapper mapper;
    private final AccountModelMapper accountModelMapper;

    @Override
    @Transactional
    public AccountModel handle(CreateUserModel create) {
        accountRepository.findByName(create.getUsername())
                .ifPresent(e -> EntityAlreadyExists.from(e));

        AccountEntity entity = mapper.convert(create);
        accountRepository.save(entity);
        log.info("new account has been created: " + entity.getName());
        return accountModelMapper.convert(entity);
    }
}
