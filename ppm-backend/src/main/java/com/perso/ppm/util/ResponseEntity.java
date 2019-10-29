package com.perso.ppm.util;

import lombok.Data;

@Data
public class ResponseEntity<T> {
    private ResponseStatus status;
    private String message;
    private T content;

    public ResponseEntity(ResponseStatus status, String message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }
}
