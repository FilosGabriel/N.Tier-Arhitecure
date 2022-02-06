package com.filos.application.services.commands;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.filos.application.models.account.AccountModel;
import com.filos.application.models.user.CreateUserModel;


public class AccountingServiceCommands {
    public record FindByName(String accountName) implements Command<AccountModel> {
    }

    public record SaveChanges(String name, AccountModel update) implements Command<Voidy> {
    }

    public record Create(CreateUserModel createUserModel) implements Command<AccountModel> {

    }
}
