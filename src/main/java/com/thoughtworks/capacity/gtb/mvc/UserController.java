package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user){
        this.userService.createUser(user);
    }

    @GetMapping("/login")
    @ResponseBody
    public User userLogin(@RequestParam("username") String  username, @RequestParam("password") String  password){
        return userService.login(username,password);
    }
}
