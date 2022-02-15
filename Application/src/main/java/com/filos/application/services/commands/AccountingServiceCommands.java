package com.filos.application.services.commands;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.filos.application.models.account.AccountModel;


public class AccountingServiceCommands {
    public record FindByName(String accountName) implements Command<AccountModel> {
    }

    public record SaveChanges(String name, AccountModel update) implements Command<Voidy> {
    }

}
