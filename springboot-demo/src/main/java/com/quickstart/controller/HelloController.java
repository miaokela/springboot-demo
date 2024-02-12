package com.quickstart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickstart.utils.ApiResponse;

import io.swagger.annotations.Api;


@Api(tags = "Hello接口")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ApiResponse<String> hello() {
        return new ApiResponse<>(HttpStatus.OK.value(), "操作成功", "Hello World!");
    }
}
