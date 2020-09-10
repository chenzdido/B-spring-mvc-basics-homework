package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameDuplicate extends RuntimeException{
    public UserNameDuplicate(String message) {
        super(message);
    }
}
