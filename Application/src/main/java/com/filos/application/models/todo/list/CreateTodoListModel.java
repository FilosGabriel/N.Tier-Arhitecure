package com.filos.application.models.todo.list;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class CreateTodoListModel {
    @Length(min = 5, max = 50, message = "Todo item title '${validatedValue}' should have between ${min} and ${max} characters")
    String title;
}
