package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static Integer count=0;
    private Integer id;
    private String username;
    private String password;
    private String email;

    User(String username,String password,String email){
        id=++count;
        this.username=username;
        this.password=password;
        this.email=email;
    }
}
