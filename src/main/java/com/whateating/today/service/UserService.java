package com.whateating.today.service;

import com.whateating.today.integration.dto.UserRequest;
import com.whateating.today.integration.dto.UserResponse;

import java.util.List;


public interface UserService {
    List<UserResponse> getAllUsers();

    Long createUser(UserRequest userRequest);

    UserResponse getUserById(Long userId);

    UserResponse modifyUserById(Long userId);

    Long deleteUser(Long userId);
}
