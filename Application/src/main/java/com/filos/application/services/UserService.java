package com.filos.application.services;

import com.filos.application.models.user.*;

import java.util.concurrent.CompletableFuture;

public interface UserService {

    CompletableFuture<ConfirmEmailResponseModel> confirmEmailAsync(ConfirmEmailModel confirmEmailModel);

    CompletableFuture<CreateUserResponseModel> createAsync(CreateUserModel createUserModel);

    CompletableFuture<LoginUserResponseModel> loginAsync(LoginUserModel loginUserModel);

}
