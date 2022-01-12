package com.filos.core.entities;

import com.filos.core.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "todo_list", schema = "todos")
@NoArgsConstructor
@Getter
@Setter
public class TodoList extends BaseEntity {
    private String title;
    @OneToMany
    private List<TodoItem> todos;
}
