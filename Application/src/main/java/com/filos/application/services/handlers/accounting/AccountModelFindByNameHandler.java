package com.filos.application.services.handlers.accounting;

import an.awesome.pipelinr.Command;
import com.filos.application.models.account.AccountModel;
import com.filos.application.models.mappers.account.model.AccountEntityMapper;
import com.filos.application.services.commands.AccountingServiceCommands;
import com.filos.dataaccess.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountModelFindByNameHandler implements Command.Handler<AccountingServiceCommands.FindByName, AccountModel> {
    private final AccountRepository accountRepository;
    private final AccountEntityMapper mapper;

    @Override
    public AccountModel handle(AccountingServiceCommands.FindByName findByName) {
        return accountRepository.findByName(findByName.accountName())
                .map(mapper::convert)
                .orElseThrow();
    }
}
