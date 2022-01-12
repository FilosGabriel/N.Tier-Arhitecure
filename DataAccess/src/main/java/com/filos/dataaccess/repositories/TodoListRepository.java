package com.filos.dataaccess.repositories;

import com.filos.core.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoListRepository extends JpaRepository<TodoList, UUID> {
}
