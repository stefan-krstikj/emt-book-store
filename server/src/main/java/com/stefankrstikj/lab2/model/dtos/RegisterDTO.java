package com.stefankrstikj.lab2.model.dtos;

import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String repeatPassword;
    private String name;
    private String surname;
}
