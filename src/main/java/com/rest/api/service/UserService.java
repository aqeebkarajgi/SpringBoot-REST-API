package com.rest.api.service;

import com.rest.api.repository.UserRepository;
import com.rest.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(String name, int age){
        return userRepository.save(new User(name, age));
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getByName(String name){
        return userRepository.findByName(name);
    }

    public User update(String name, int age) {
        User user = userRepository.findByName(name);
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    public void delete(String name) {
        User user = userRepository.findByName(name);
        userRepository.delete(user);
    }
}
