package com.filos.application.models.todo.item;

import com.filos.core.enums.StatusTodo;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TodoItemResponseModel {
    String title;
    String body;
    StatusTodo status;
}