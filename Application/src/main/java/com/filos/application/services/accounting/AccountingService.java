package com.filos.application.services.accounting;

import com.filos.application.models.account.AccountModel;
import com.filos.application.models.user.CreateUserModel;

public interface AccountingService {
    AccountModel findByName(String accountName);

    AccountModel create(CreateUserModel createUserModel);

    void saveChanges(String name, AccountModel update);
}
