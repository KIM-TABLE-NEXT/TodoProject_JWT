package com.sparta.todoproject_jwt.controller;

import com.sparta.todoproject_jwt.dto.TodoRequestDto;
import com.sparta.todoproject_jwt.dto.TodoResponseDto;
import com.sparta.todoproject_jwt.security.UserDetailsImpl;
import com.sparta.todoproject_jwt.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/param")
    public TodoResponseDto getTodoById(@RequestParam Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.getTodoById(id, userDetails.getUser());
    }

    @GetMapping("/search/param")
    public List<TodoResponseDto> getTodoByTitle(@RequestParam String title, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.getTodoListByTitle(title, userDetails.getUser());
    }

    @GetMapping("/all")
    public List<TodoResponseDto> getTodoList(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.getTodoList(userDetails.getUser());
    }

    @PutMapping("/param")
    public TodoResponseDto updateTodoById(@RequestParam Long id, @RequestBody TodoRequestDto requestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.updateTodoById(id, userDetails.getUser(), requestDto);
    }

    @PutMapping("/completion/param")
    public String updateTodoCompletion(@RequestParam Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.updateTodoCompletion(id, userDetails.getUser());
    }

    @PutMapping("/disclosure/param")
    public String updateTodoDisclosure(@RequestParam Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return todoService.updateTodoDisclosure(id, userDetails.getUser());
    }
}
