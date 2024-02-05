package com.sparta.todoproject_jwt.controller;

import com.sparta.todoproject_jwt.dto.CommentRequestDto;
import com.sparta.todoproject_jwt.dto.CommentResponseDto;
import com.sparta.todoproject_jwt.security.UserDetailsImpl;
import com.sparta.todoproject_jwt.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/param")
    public CommentResponseDto createCommentByTodoId(@RequestParam Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.createCommentByTodoId(id, userDetails.getUser(), requestDto);
    }

    @PutMapping("/param")
    public CommentResponseDto updateCommentById(@RequestParam Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.updateCommentById(id, userDetails.getUser(), requestDto);
    }

    @DeleteMapping("/param")
    public String deleteCommentById(@RequestParam Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.deleteCommentById(id, userDetails.getUser());
    }
}
