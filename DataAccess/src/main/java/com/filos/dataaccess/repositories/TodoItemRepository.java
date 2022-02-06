package com.filos.dataaccess.repositories;


import com.filos.core.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@NoRepositoryBean

public interface TodoItemRepository extends JpaRepository<TodoItem, UUID> {
    CompletableFuture<List<TodoItem>> findByTodoListId(UUID id);
}
