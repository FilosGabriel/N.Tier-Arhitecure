package com.filos.api.controllers.v2;

import an.awesome.pipelinr.Pipeline;
import com.filos.application.models.account.AccountModel;
import com.filos.application.models.user.CreateUserModel;
import com.filos.application.services.commands.AccountingServiceCommands.FindByName;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

import static com.filos.application.services.commands.AccountingServiceCommands.Create;
import static com.filos.application.services.commands.AccountingServiceCommands.SaveChanges;

@Value
@RestController
@RequestMapping("/accounts")
public class AccountController {
    Pipeline pipeline;

    @GetMapping("/{account}")
    public AccountModel getSpecificAccount(@PathVariable String name) {
        return new FindByName(name).execute(pipeline);
    }

    @GetMapping("/current")
    public AccountModel currentAccount(Principal principal) {
        return new FindByName(principal.getName()).execute(pipeline);
    }

    @GetMapping("/demo")
    public void demoAccount() {

    }

    @PutMapping("/current")
    public void updateCurrentAccount(Principal principal, @Valid @RequestBody AccountModel account) {
        new SaveChanges(principal.getName(), account).execute(pipeline);
    }

    @PostMapping
    public AccountModel registerAccount(@Valid @RequestBody CreateUserModel createUserModel) {
        return new Create(createUserModel).execute(pipeline);
    }
}
