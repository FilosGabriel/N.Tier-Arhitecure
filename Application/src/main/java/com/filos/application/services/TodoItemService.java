package com.filos.application.services;

import com.filos.application.models.todo.item.CreateTodoItemModel;
import com.filos.application.models.todo.item.CreateTodoItemResponseModel;
import com.filos.application.models.todo.item.TodoItemResponseModel;
import com.filos.application.models.todo.item.UpdateTodoItemModel;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface TodoItemService {
    CompletableFuture<CreateTodoItemResponseModel> createAsync(CreateTodoItemModel createTodoItemModel);

    CompletableFuture<CreateTodoItemModel> deleteAsync(UUID id);

    CompletableFuture<Collection<TodoItemResponseModel>> getAllByListIdAsync(UUID id);

    CompletableFuture<UpdateTodoItemModel> updateAsync(UUID id, UpdateTodoItemModel updateTodoItemModel);
}
