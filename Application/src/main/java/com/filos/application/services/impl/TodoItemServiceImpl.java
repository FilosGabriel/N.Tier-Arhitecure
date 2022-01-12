package com.filos.application.services.impl;

import com.filos.application.models.mappers.TodoItemMapper;
import com.filos.application.models.todo.item.CreateTodoItemModel;
import com.filos.application.models.todo.item.CreateTodoItemResponseModel;
import com.filos.application.models.todo.item.TodoItemResponseModel;
import com.filos.application.models.todo.item.UpdateTodoItemModel;
import com.filos.application.services.TodoItemService;
import com.filos.dataaccess.repositories.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class TodoItemServiceImpl implements TodoItemService {
    private final TodoItemRepository todoItemRepository;
    private final TodoItemMapper mapper;

    @Override
    public CompletableFuture<CreateTodoItemResponseModel> createAsync(CreateTodoItemModel createTodoItemModel) {
        return null;
    }

    @Override
    public CompletableFuture<CreateTodoItemModel> deleteAsync(UUID id) {
        todoItemRepository.deleteById(id);
        boolean b = true;
        if (!b) {

        }
        long l = 55L;
        long l1 = 45L;
    long min = Long.min(l1, );
        return CompletableFuture.completedFuture(mapper.map(id));
    }

    @Override
    public CompletableFuture<Collection<TodoItemResponseModel>> getAllByListIdAsync(UUID id) {
        return todoItemRepository.findByTodoListId(id)
                .thenApply(mapper::map);
    }

    @Override
    public CompletableFuture<UpdateTodoItemModel> updateAsync(UUID id, UpdateTodoItemModel updateTodoItemModel) {
        return null;
    }
}


