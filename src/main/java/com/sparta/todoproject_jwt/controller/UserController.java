package com.sparta.todoproject_jwt.controller;

import com.sparta.todoproject_jwt.dto.ResponseDto;
import com.sparta.todoproject_jwt.dto.SignInRequestDto;
import com.sparta.todoproject_jwt.dto.SignUpRequestDto;
import com.sparta.todoproject_jwt.dto.SignUpResponseDto;
import com.sparta.todoproject_jwt.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpRequestDto requestDto){
        log.info("회원가입");
        return userService.signUp(requestDto);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseDto> signIn(@RequestBody SignInRequestDto requestDto){
        log.info("로그인");
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, userService.signIn(requestDto)).body(new ResponseDto("로그인 성공"));
    }
}
