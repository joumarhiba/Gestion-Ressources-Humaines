package com.GRH.exception;


public class NoItemsFoundException extends RuntimeException {
    public NoItemsFoundException(String message) {
        super(message);
    }
}
