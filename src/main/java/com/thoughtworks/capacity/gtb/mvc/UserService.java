package com.thoughtworks.capacity.gtb.mvc;

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
        User newUser =new User(user.getUsername(),user.getPassword(),user.getEmail());
        userMap.put(newUser.getUsername(),newUser);
    }

    public User login(String username,String password){
        User user=userMap.get(username);
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
