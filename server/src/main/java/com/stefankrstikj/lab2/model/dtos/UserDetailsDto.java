package com.stefankrstikj.lab2.model.dtos;

import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(User user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}
