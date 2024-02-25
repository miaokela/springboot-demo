package com.quickstart.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * 自定义全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<String> hanldeException(Exception e) {
        return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误", null);
    }

    @ExceptionHandler(OtherException.class)
    @ResponseBody
    public ApiResponse<String> handleOtherException(OtherException e) {
        return new ApiResponse<>(e.getCode(), e.getMessage(), null);
    }
}
