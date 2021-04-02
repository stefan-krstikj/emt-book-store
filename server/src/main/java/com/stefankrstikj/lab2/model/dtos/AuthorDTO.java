package com.stefankrstikj.lab2.model.dtos;

import lombok.Data;

@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private String surname;
    private String country;
}
