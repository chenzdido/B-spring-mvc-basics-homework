package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserNameDuplicate;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserPasswordWrong;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> userMap=new HashMap<>();

    public UserService(){
        User user=new User("Tom","12345","tom@qq.com");
        userMap.put(user.getUsername(),user);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
    }

    public void createUser(User user){
        if(userMap.get(user.getUsername())!=null){
            throw new UserNameDuplicate("username already exists");
        }
        User newUser =new User(user.getUsername(),user.getPassword(),user.getEmail());
        userMap.put(newUser.getUsername(),newUser);
    }

    public User login(String username,String password){
        User user=userMap.get(username);
        if(user==null){
            throw new UserNotFoundException("user not found");
        }
        if(user.getPassword().equals(password)){
            return user;
        }else{
            throw new UserPasswordWrong("password wrong");
        }

    }
}
