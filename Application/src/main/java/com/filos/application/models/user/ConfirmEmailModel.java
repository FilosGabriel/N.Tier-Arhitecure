package com.filos.application.models.user;

import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
public class ConfirmEmailModel {
    @NotEmpty(message = "Your validation link is not valid.")
    String userId;
    @NotEmpty(message = "Your validation link is not valid.")
    String token;
}
