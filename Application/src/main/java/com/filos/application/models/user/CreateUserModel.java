package com.filos.application.models.user;

import com.filos.application.models.validators.user.UniqueEmail;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Value
public class CreateUserModel {
    @Length(min = 5, max = 20, message = "Username should have minimum {min} and maximum {max} characters")
    String username;
    @Email
    @UniqueEmail
    String email;
    @Length(min = 6, max = 128)
    String password;
}
