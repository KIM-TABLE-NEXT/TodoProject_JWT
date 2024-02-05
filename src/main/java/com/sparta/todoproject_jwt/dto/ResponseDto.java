package com.sparta.todoproject_jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

    private String message;
    private Object data;

    public ResponseDto(String message){
        this.message = message;
    }
}
