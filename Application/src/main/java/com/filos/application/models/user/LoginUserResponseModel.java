package com.filos.application.models.user;

import lombok.Value;

@Value
public class LoginUserResponseModel {
    String username;
    String email;
    String token;
}
