package com.ks.fbs.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
