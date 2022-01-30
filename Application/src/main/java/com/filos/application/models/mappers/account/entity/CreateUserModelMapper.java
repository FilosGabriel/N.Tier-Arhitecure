package com.filos.application.models.mappers.account.entity;

import com.filos.application.models.user.CreateUserModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface CreateUserModelMapper extends Converter<AccountEntity, CreateUserModel> {
    AccountEntity convert(CreateUserModel createUserModel);
}
