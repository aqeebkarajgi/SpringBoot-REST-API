package com.rest.api.controller;

import com.rest.api.entity.User;
import com.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> findAllUsers() {
        return userService.getAll();
    }

    @RequestMapping("/user")
    public User findUser(@RequestParam String name) {
        return userService.getByName(name);
    }

}
