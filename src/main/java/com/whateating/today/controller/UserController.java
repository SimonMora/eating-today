package com.whateating.today.controller;

import com.whateating.today.integration.dto.UserRequest;
import com.whateating.today.integration.dto.UserResponse;
import com.whateating.today.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll", produces = "application/json")
    private ResponseEntity<List<UserResponse>> getAllUsers() {
        LOG.info("Getting all users from database.");
        return userService.getAllUsers();
    }

    @PostMapping(value= "/create", consumes = "application/json", produces = "application/json")
    private ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        LOG.info("Attempting to save user in database.");
        return userService.createUser(userRequest);
    }
}
