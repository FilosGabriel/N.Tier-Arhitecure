package com.filos.application.models.todo.item;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Value
public class CreateTodoItemModel {
    UUID id;
    @Length(min = 5, max = 50, message = "Todo item title '${validatedValue}' should have between ${min} and ${max} characters")
    String title;
    @Length(min = 5, max = 100, message = "Todo item body '${validatedValue}' should have between ${min} and ${max} characters")
    String Body;
}
