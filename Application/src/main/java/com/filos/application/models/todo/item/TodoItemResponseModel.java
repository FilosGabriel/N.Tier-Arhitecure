package com.filos.application.models.todo.item;

import lombok.Value;

@Value
public class TodoItemResponseModel {
    String title;
    String body;
    boolean isDone;
}