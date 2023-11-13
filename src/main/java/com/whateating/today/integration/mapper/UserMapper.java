package com.whateating.today.integration.mapper;

import com.whateating.today.integration.dto.UserRequest;
import com.whateating.today.integration.dto.UserResponse;
import com.whateating.today.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserResponse(User user);

    User userRequestToUser(UserRequest userRequest);

}
