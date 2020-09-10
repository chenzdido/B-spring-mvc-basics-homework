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
    @NotBlank
    @Size(max=10,min=3)
    @Pattern(regexp ="^\\w+$")
    private String username;
    @NotBlank
    @Size(max=12,min=5)
    private String password;
    @Email
    private String email;

    public User(String username, String password, String email){
        this.id = ++this.count;
        this.username=username;
        this.password=password;
        this.email=email;
    }
}
