package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.model.enumerations.Role;
import com.stefankrstikj.lab2.repository.UserRepository;
import com.stefankrstikj.lab2.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) throws Exception {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new Exception("Invalid username");
        if (!password.equals(repeatPassword))
            throw new Exception("Incorrect password");
        if (this.userRepository.findByUsername(username).isPresent())
            throw new Exception("Username already exists");
        User user = new User(username, passwordEncoder.encode(password), name, surname, Role.ROLE_USER);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAlUsers() {
        return userRepository.fetchAll();
    }
}
