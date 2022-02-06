package com.filos.application.services.handlers.accounting;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.filos.application.services.commands.AccountingServiceCommands;
import com.filos.core.entities.AccountEntity;
import com.filos.core.exception.EntityNotFound;
import com.filos.dataaccess.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;

import javax.transaction.Transactional;

//@Component
@RequiredArgsConstructor
public class AccountModelSaveChanges implements Command.Handler<AccountingServiceCommands.SaveChanges, Voidy> {
    private final AccountRepository accountRepository;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public Voidy handle(AccountingServiceCommands.SaveChanges saveChanges) {
        accountRepository.findByName(saveChanges.name())
                .orElseThrow(EntityNotFound::new);

        AccountEntity entity = conversionService.convert(saveChanges.update(), AccountEntity.class);
        accountRepository.save(entity);
        return new Voidy();
    }
}
