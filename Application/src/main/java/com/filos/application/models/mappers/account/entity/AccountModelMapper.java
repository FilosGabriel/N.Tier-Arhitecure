package com.filos.application.models.mappers.account.entity;

import com.filos.application.models.account.AccountModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountModelMapper {

    @Mapping(target = "savings", ignore = true)
    @Mapping(target = "incomes", ignore = true)
    @Mapping(target = "expenses", ignore = true)
    AccountModel convert(AccountEntity accountModel);

}
