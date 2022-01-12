package com.filos.application.services;

import com.filos.application.models.todo.list.*;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface TodoListService {

    CompletableFuture<CreateTodoListResponseModel> createAsync(CreateTodoListModel createTodoListModel);

    CompletableFuture<CreateTodoListResponseModel> deleteAsync(UUID id);

    CompletableFuture<Collection<TodoListResponseModel>> getAllAsync();

    CompletableFuture<UpdateTodoListResponseModel> updateAsync(UUID id, UpdateTodoListModel updateTodoListModel);

}
