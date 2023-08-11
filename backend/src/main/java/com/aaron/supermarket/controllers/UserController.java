package com.aaron.supermarket.controllers;

import com.aaron.supermarket.models.User;
import com.aaron.supermarket.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> get() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }
}
