package com.sparta.todoproject_jwt.controller;

import com.sparta.todoproject_jwt.dto.TodoRequestDto;
import com.sparta.todoproject_jwt.dto.TodoResponseDto;
import com.sparta.todoproject_jwt.security.UserDetailsImpl;
import com.sparta.todoproject_jwt.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.createTodo(requestDto, userDetails.getUser());
    }

}
