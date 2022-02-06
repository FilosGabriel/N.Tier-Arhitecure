package com.filos.dataaccess.repositories;

import com.filos.core.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean

public interface TodoListRepository extends JpaRepository<TodoList, UUID> {
}
