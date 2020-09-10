package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserPasswordWrong extends RuntimeException{
    public UserPasswordWrong(String message) {
        super(message);
    }
}
