package com.spring.springsecurity.controllers;

import com.spring.springsecurity.dto.request.UserCreationRequest;
import com.spring.springsecurity.dto.request.UserUpdateRequest;
import com.spring.springsecurity.dto.response.ApiResponse;
import com.spring.springsecurity.dto.response.UserResponse;
import com.spring.springsecurity.entities.User;
import com.spring.springsecurity.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @PostMapping()
    public ApiResponse<User> createUser(@RequestBody @Validated UserCreationRequest userCreationRequest) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(userCreationRequest));
        return apiResponse;
    }

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        try {
            userService.getUserById(userId);
            userService.deleteUser(userId);
            return "User deleted successfully!";
        } catch (Exception e) {
            return "User not found!";
        }
    }


}
