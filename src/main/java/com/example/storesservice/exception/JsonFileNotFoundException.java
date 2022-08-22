package com.example.storesservice.exception;

public class JsonFileNotFoundException extends RuntimeException {
    public JsonFileNotFoundException(String message) {
        super(message);
    }
}
