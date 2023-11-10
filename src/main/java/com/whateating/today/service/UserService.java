package com.whateating.today.service;

import com.whateating.today.integration.dto.UserRequest;
import com.whateating.today.integration.dto.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    ResponseEntity<List<UserResponse>> getAllUsers();

    ResponseEntity<String> createUser(UserRequest userRequest);
}
