package com.filos.application.models.mappers;

import com.filos.application.models.todo.item.CreateTodoItemModel;
import com.filos.application.models.todo.item.TodoItemResponseModel;
import com.filos.core.entities.TodoItem;

import java.util.Collection;
import java.util.UUID;

public interface TodoItemMapper {

    TodoItemResponseModel map(TodoItem item);

    Collection<TodoItemResponseModel> map(Collection<TodoItem> items);

    CreateTodoItemModel  map(UUID id);

}
