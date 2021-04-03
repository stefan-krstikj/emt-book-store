package com.stefankrstikj.lab2.model.dtos;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private Long authorId;
    private Integer availableCopies;

}
