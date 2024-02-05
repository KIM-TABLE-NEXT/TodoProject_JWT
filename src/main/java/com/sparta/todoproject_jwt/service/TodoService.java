package com.sparta.todoproject_jwt.service;

import com.sparta.todoproject_jwt.dto.TodoRequestDto;
import com.sparta.todoproject_jwt.dto.TodoResponseDto;
import com.sparta.todoproject_jwt.entity.Todo;
import com.sparta.todoproject_jwt.entity.User;
import com.sparta.todoproject_jwt.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto, User user) {
        Todo todo = todoRepository.save(new Todo(requestDto, user));
        return new TodoResponseDto(todo);
    }
}
