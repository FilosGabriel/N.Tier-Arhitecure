package com.filos.application.models.mappers.account.model;

import com.filos.application.models.account.AccountModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface AccountEntityMapper extends Converter<AccountModel, AccountEntity> {
    AccountModel convert(AccountEntity entity);

}
