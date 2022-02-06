package com.filos.application.models.mappers.account.entity;

import com.filos.application.models.user.CreateUserModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

//@Mapper
public interface CreateUserModelMapper extends Converter<AccountEntity, CreateUserModel> {

    @Mapping(target = "name", source = "username")
    @Mapping(target = "lastSeen", expression = "java(LocalDate.now())")
    @Mapping(target = "incomes", ignore = true)
    @Mapping(target = "expenses", ignore = true)
    @Mapping(target = "saving", ignore = true)
    @Mapping(target = "note", ignore = true)
    AccountEntity convert(CreateUserModel createUserModel);
}
