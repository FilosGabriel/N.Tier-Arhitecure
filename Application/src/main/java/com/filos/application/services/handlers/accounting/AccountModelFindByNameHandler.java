package com.filos.application.services.handlers.accounting;

import an.awesome.pipelinr.Command;
import com.filos.application.models.account.AccountModel;
import com.filos.application.services.commands.AccountingServiceCommands;
import com.filos.dataaccess.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountModelFindByNameHandler implements Command.Handler<AccountingServiceCommands.FindByName, AccountModel> {
    AccountRepository accountRepository;
    ConversionService conversionService;


    @Override
    public AccountModel handle(AccountingServiceCommands.FindByName findByName) {
        return accountRepository.findByName(findByName.accountName())
                .map(account -> conversionService.convert(account, AccountModel.class))
                .orElseThrow();
    }
}
