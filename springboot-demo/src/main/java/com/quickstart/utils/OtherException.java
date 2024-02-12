package com.quickstart.utils;

import lombok.Getter;

@Getter
public class OtherException extends RuntimeException {
    private int code;

    public OtherException(int code, String message) {
        super(message);
        this.code = code;
    }
}
