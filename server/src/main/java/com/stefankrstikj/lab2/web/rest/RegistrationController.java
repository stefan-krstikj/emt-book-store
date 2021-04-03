package com.stefankrstikj.lab2.web.rest;

import com.stefankrstikj.lab2.model.dtos.RegisterDTO;
import com.stefankrstikj.lab2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @PostMapping
    public void register(@RequestBody RegisterDTO user) throws Exception {
        userService.register(user.getUsername(), user.getPassword(), user.getRepeatPassword(),
                user.getName(), user.getSurname());
    }
}
