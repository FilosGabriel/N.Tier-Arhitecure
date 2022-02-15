package com.filos.api.controllers.v2;

import an.awesome.pipelinr.Pipeline;
import com.filos.application.models.account.AccountModel;
import com.filos.application.models.user.CreateUserModel;
import com.filos.application.services.commands.AccountingServiceCommands.FindByName;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

import static com.filos.application.services.commands.AccountingServiceCommands.SaveChanges;

@Value
@RestController
@RequestMapping("/accounts")
public class AccountController {
    Pipeline pipeline;

    @GetMapping("/{accountName}")
    public AccountModel getSpecificAccount(@PathVariable String accountName) {
        return new FindByName(accountName).execute(pipeline);
    }

    @GetMapping("/current")
    public AccountModel currentAccount(Principal principal) {
        return new FindByName(principal.getName()).execute(pipeline);
    }

    @PutMapping("/current")
    public void updateCurrentAccount(Principal principal, @Valid @RequestBody AccountModel account) {
        new SaveChanges(principal.getName(), account).execute(pipeline);
    }

    @PostMapping
    public AccountModel registerAccount(@Valid @RequestBody CreateUserModel createUserModel) {
        return createUserModel.execute(pipeline);
    }
}
