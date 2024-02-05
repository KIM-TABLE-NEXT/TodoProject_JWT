package com.sparta.todoproject_jwt.dto;

import com.sparta.todoproject_jwt.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoResponseDto {

    private Long todoId;
    private String title;
    private String content;
    private String username;
    private LocalDateTime dateCreated;
    private boolean isCompleted;
    private boolean isPrivate;

    public TodoResponseDto(Todo todo) {
        this.todoId = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.username = todo.getUser().getUsername();
        this.dateCreated = todo.getCreatedAt();
        this.isCompleted = todo.isCompleted();
        this.isPrivate = todo.isPrivate();
    }
}
