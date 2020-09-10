package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static Integer count=0;
    private Integer id;
    @NotBlank(message = "username is not empty")
    @Size(max=10,min=3,message = "user name length is 3 to 10")
    @Pattern(regexp ="^\\w+$",message = "username is incorrectly named")
    private String username;
    @NotBlank(message = "password is not empty")
    @Size(max=12,min=5,message = "password length is 5 to 12")
    private String password;
    @Email(message = "invalid email address")
    private String email;

    public User(String username, String password, String email){
        this.id = ++this.count;
        this.username=username;
        this.password=password;
        this.email=email;
    }
}
