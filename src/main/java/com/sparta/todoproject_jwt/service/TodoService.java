package com.sparta.todoproject_jwt.service;

import com.sparta.todoproject_jwt.dto.TodoRequestDto;
import com.sparta.todoproject_jwt.dto.TodoResponseDto;
import com.sparta.todoproject_jwt.entity.Todo;
import com.sparta.todoproject_jwt.entity.User;
import com.sparta.todoproject_jwt.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto requestDto, User user) {
        Todo todo = todoRepository.save(new Todo(requestDto, user));
        return new TodoResponseDto(todo);
    }

    public TodoResponseDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 id의 할일이 존재하지 않습니다.")
                );
        return new TodoResponseDto(todo);
    }

    public List<TodoResponseDto> getTodoList(User user) {
        List<Todo> todoList = todoRepository.findAllByUser(user);
        List<TodoResponseDto> todoResponseDtoList = new ArrayList<>();

        for (Todo todo : todoList) {
            todoResponseDtoList.add(new TodoResponseDto(todo));
        }
        return todoResponseDtoList;
    }
}
