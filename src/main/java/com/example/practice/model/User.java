package com.example.practice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private Integer status;
    private Boolean isActive;
    private String role;
    private String createdAt;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
