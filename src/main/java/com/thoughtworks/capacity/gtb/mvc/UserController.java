package com.thoughtworks.capacity.gtb.mvc;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
