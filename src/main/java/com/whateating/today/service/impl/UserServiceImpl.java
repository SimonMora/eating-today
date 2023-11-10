package com.whateating.today.service.impl;

import com.whateating.today.integration.dto.UserRequest;
import com.whateating.today.integration.dto.UserResponse;
import com.whateating.today.model.User;
import com.whateating.today.repository.UserRepository;
import com.whateating.today.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        LOG.info(MarkerFactory.getMarker("UserService"), "retrieve all users now.");

        List<UserResponse> response = new ArrayList<>();
        List<User> userList = userRepository.findAll();

        if(!userList.isEmpty()) {
            LOG.info(MarkerFactory.getMarker("UserService"), "users were found in database.");
            userList.forEach(user ->
                    response.add(new UserResponse(user.getUserName(), user.getEmail()))
            );
        }

        return ResponseEntity.of(Optional.of(response));
    }

    @Override
    public ResponseEntity<String> createUser(UserRequest userRequest) {
        final User userToSave = new User(null, userRequest.getUserName(), userRequest.getEmail(), null);
        LOG.info("User will be save in the database now.");
        User savedUser = userRepository.save(userToSave);
        return (savedUser != null && savedUser.getId() != null) ?
                ResponseEntity.ok("User created") : ResponseEntity.badRequest().body("Error saving the user");
    }


}
