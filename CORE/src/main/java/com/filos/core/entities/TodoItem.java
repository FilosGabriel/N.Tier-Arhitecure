package com.filos.core.entities;

import com.filos.core.common.BaseEntity;
import com.filos.core.enums.StatusTodo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Access(value = AccessType.FIELD)
@Table(name = "todo_item", schema = "todos")
@NoArgsConstructor
@Getter
@Setter
public class TodoItem extends BaseEntity {
    private String title;
    @Column(columnDefinition = "nvarchar(max)")
    private String body;
    @Enumerated(EnumType.STRING)
    private StatusTodo status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private AttachmentEntity attachment;

    @OneToOne
    private TodoList todoList;

}
