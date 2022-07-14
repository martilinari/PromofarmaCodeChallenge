package com.profarma.challenge.profarmacodechallenge.common;

import java.time.LocalDateTime;

public class ApiResponse {
    private final String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}