package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.repository.UserRepository;
import com.stefankrstikj.lab2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) throws Exception {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new Exception("Invalid number of arguments");
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(Exception::new);
    }

}
