package com.stefankrstikj.lab2.web.rest;

import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.model.projections.UserProjection;
import com.stefankrstikj.lab2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> findALlUsers(){
        return userService.findAlUsers();
    }
}
