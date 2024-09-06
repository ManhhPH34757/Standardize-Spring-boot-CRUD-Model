package com.spring.springsecurity.mapper;

import com.spring.springsecurity.dto.request.UserCreationRequest;
import com.spring.springsecurity.dto.request.UserUpdateRequest;
import com.spring.springsecurity.dto.response.UserResponse;
import com.spring.springsecurity.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
