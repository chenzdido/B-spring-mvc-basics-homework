package com.thoughtworks.capacity.gtb.mvc;

public class UserNameDuplicate extends RuntimeException{
    public UserNameDuplicate(String message) {
        super(message);
    }
}
