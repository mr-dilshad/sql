package com.example.sql.controller;

import com.example.sql.entity.UserEntity;
import com.example.sql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;
    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userRepository.save(user);
        return "User Created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable < UserEntity > getAllUsers() {
        return userRepository.findAll();
    }

}

