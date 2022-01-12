package com.filos.application.models.mappers;

import com.filos.application.models.todo.item.TodoItemResponseModel;
import com.filos.core.entities.TodoItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper
public interface TodoItemMapper {

    TodoItemResponseModel mapToDto(TodoItem item);

    @ToEntityMapping
    @InheritInverseConfiguration
    @Mapping(target = "attachment", expression = "java(null)")
    @Mapping(target = "todoList", ignore = true)
    TodoItem map(TodoItemResponseModel item);

    Collection<TodoItemResponseModel> mapToDto(Collection<TodoItem> items);

    Collection<TodoItem> map(Collection<TodoItemResponseModel> items);

}
