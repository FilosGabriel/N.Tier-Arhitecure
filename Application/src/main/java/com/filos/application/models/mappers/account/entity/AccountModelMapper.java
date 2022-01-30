package com.filos.application.models.mappers.account.entity;

import com.filos.application.models.account.AccountModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AccountModelMapper extends Converter<AccountEntity, AccountModel> {

    AccountEntity convert(AccountModel accountModel);

}
