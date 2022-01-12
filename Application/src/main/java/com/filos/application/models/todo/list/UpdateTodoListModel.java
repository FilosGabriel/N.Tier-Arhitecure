package com.filos.application.models.todo.list;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class UpdateTodoListModel {
    @Length(min = 5, max = 50, message = "Todo item body '${validatedValue}' should have between ${min} and ${max} characters")
    String title;
}
