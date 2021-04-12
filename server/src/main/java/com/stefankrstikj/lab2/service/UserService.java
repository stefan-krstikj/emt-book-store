package com.stefankrstikj.lab2.service;

import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.model.enumerations.Role;
import com.stefankrstikj.lab2.model.projections.UserProjection;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname) throws Exception;
    List<User> findAlUsers();
}
