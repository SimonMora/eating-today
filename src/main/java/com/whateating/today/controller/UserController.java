package com.whateating.today.controller;

import com.whateating.today.integration.dto.UserRequest;
import com.whateating.today.integration.dto.UserResponse;
import com.whateating.today.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value= "/getAll", produces = "application/json")
    private ResponseEntity<List<UserResponse>> getAllUsers() {
        LOG.info("Getting all users from database.");
        return ResponseEntity.of(Optional.of(userService.getAllUsers()));
    }

    @PostMapping(value= "/create", consumes = "application/json", produces = "application/json")
    private ResponseEntity<String> createUser(@RequestBody UserRequest user) {
        LOG.info("Attempting to save user in database.");
        final Long userId = userService.createUser(user);
        return userId != null ? ResponseEntity.ok("User created")
                : ResponseEntity.badRequest().body("Error saving the user");
    }

    @GetMapping(value= "/findUser/{userId}", produces = "application/json")
    private ResponseEntity<UserResponse> findUser(@PathVariable("userId") Long userId) {
        LOG.info("Finding users by id.");
        final UserResponse user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value= "/modifyUser/{userId}", consumes = "application/json", produces = "application/json")
    private ResponseEntity<UserResponse> modifyUser(@PathVariable("userId") Long userId, @RequestBody UserRequest user) {
        LOG.info("Modifying users by id.");
        final UserResponse modifiedUser = userService.modifyUserById(userId);
        return ResponseEntity.ok(modifiedUser);
    }

    @DeleteMapping(value = "/deleteUser/{userId}", produces = "application/json")
    private ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){
        LOG.info("Deleting users by id.");
        return null;
    }

}
