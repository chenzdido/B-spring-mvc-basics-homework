package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<Integer, User> userMap=new HashMap<>();

    public UserService(){
        userMap.put(1, new User("Tom","12345","tom@qq.com"));
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
    }

    public User createUser(User user){
        User newUser =new User(user.getUsername(),user.getPassword(),user.getPassword());
        userMap.put(newUser.getId(),newUser);
        System.out.println(newUser);
        return newUser;
    }
}
