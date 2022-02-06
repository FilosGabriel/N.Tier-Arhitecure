package com.filos.application.models.mappers.account.model;

import com.filos.application.models.account.AccountModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

//@Mapper
public interface AccountEntityMapper extends Converter<AccountModel, AccountEntity> {
    @Mapping(target = "incomes", ignore = true)
    @Mapping(target = "expenses", ignore = true)
    AccountModel convert(AccountEntity entity);

}
