package com.filos.api.controllers.v2;

import com.filos.application.models.account.AccountModel;
import com.filos.application.models.user.CreateUserModel;
import com.filos.application.services.accounting.AccountingService;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Value
@RestController
@RequestMapping("/accounts")
public class AccountController {
    AccountingService accountingService;

    @GetMapping("/{account}")
    public AccountModel getSpecificAccount(@PathVariable String name) {
        return accountingService.findByName(name);
    }

    @GetMapping("/current")
    public AccountModel currentAccount(Principal principal) {
        return accountingService.findByName(principal.getName());
    }

    @GetMapping("/demo")
    public void demoAccount() {

    }

    @PutMapping("/current")
    public void updateCurrentAccount(Principal principal, @Valid @RequestBody AccountModel account) {
        accountingService.saveChanges(principal.getName(), account);
    }

    @PostMapping
    public AccountModel registerAccount(@Valid @RequestBody CreateUserModel createUserModel) {
        return accountingService.create(createUserModel);

    }
}
