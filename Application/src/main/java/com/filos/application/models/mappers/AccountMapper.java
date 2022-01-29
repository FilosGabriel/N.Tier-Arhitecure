package com.filos.application.models.mappers;

import com.filos.application.models.account.AccountModel;
import com.filos.application.models.user.CreateUserModel;
import com.filos.core.entities.AccountEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountModel mapToModelI(AccountEntity account);

    AccountEntity mapFromCreate(CreateUserModel createUserModel);

    AccountEntity mapFromCreate(AccountModel accountModel);

    AccountModel map(AccountEntity entity);
}
