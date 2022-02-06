package com.filos.application.models.mappers.account.entity;

import com.filos.application.models.account.AccountModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

//@Mapper
public interface AccountModelMapper extends Converter<AccountEntity, AccountModel> {

    @Mapping(target = "saving", ignore = true)
    @Mapping(target = "incomes", ignore = true)
    @Mapping(target = "expenses", ignore = true)
    AccountEntity convert(AccountModel accountModel);

}
