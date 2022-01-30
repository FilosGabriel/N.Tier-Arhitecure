package com.filos.api.controllers.v2;

import com.filos.application.models.notification.RecipientModel;
import com.filos.application.services.notifications.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@RequestMapping("/recipients")
@RestController
public class RecipientController {

    private final RecipientService recipientService;

    @GetMapping("/current")
    public Object getCurrentNotificationsSettings(Principal principal) {
        return recipientService.findByAccountName(principal.getName());
    }

    @PutMapping("/current")
    public Object saveCurrentNotificationsSettings(Principal principal, @Valid @RequestBody RecipientModel recipient) {
        return recipientService.save(principal.getName(), recipient);
    }
}
