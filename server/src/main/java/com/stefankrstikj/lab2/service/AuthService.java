package com.stefankrstikj.lab2.service;

import com.stefankrstikj.lab2.model.User;

public interface AuthService {

    User login(String username, String password) throws Exception;
}
