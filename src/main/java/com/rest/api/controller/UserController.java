package com.rest.api.controller;

import com.rest.api.entity.User;
import com.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") String id) {
        return this.userRepository.findById(id);
    }

    @PutMapping("/add")
    public void addUser(@RequestBody User user) {
        this.userRepository.insert(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        this.userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        this.userRepository.deleteById(id);
    }

}
