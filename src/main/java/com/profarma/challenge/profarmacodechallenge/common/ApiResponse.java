package com.profarma.challenge.profarmacodechallenge.common;

import lombok.Data;

@Data
public class ApiResponse {
    private final String message;

    public ApiResponse(String message) {
        this.message = message;
    }

}