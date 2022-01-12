package com.filos.application.models.user;

import lombok.Value;

@Value
public class ChangePasswordModel {
    String oldPassword;
    String newPassword;
}
