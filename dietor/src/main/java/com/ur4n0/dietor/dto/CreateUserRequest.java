package com.ur4n0.dietor.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
    private double weight;
    private double height;
    private int age;        
}
