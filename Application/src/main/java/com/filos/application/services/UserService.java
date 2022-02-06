package com.filos.application.services;

import com.filos.application.models.user.ConfirmEmailModel;
import com.filos.application.models.user.ConfirmEmailResponseModel;
import com.filos.application.models.user.CreateUserModel;
import com.filos.application.models.user.CreateUserResponseModel;
import com.filos.application.models.user.LoginUserModel;
import com.filos.application.models.user.LoginUserResponseModel;

import java.util.concurrent.CompletableFuture;

public interface UserService {

    CompletableFuture<ConfirmEmailResponseModel> confirmEmailAsync(ConfirmEmailModel confirmEmailModel);

    CompletableFuture<CreateUserResponseModel> createAsync(CreateUserModel createUserModel);

    CompletableFuture<LoginUserResponseModel> loginAsync(LoginUserModel loginUserModel);

}
