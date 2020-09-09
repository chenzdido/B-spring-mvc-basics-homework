package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<Integer, User> userMap=new HashMap<>();

    public UserService(){
        userMap.put(1, new User("Tom","12345","tom@qq.com"));
    }

    public void createUser(User user){
        userMap.put(user.getId(),user);
    }
}
