package com.GRH.exception;

public class ItemIdNotFoundException extends RuntimeException {
    public ItemIdNotFoundException(String message){
        super(message);
    }
}
