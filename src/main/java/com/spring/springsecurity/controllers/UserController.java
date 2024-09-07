package com.spring.springsecurity.controllers;

import com.spring.springsecurity.dto.request.UserCreationRequest;
import com.spring.springsecurity.dto.request.UserUpdateRequest;
import com.spring.springsecurity.dto.response.ApiResponse;
import com.spring.springsecurity.dto.response.UserResponse;
import com.spring.springsecurity.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @PostMapping()
    public ApiResponse<UserResponse> createUser(@RequestBody @Validated UserCreationRequest userCreationRequest) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(userCreationRequest));
        return apiResponse;
    }

    @GetMapping()
    public ApiResponse<List<UserResponse>> getAllUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Users: {} ", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/my-info")
    public UserResponse getMyInfo() {
        return userService.getMyInfo();
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable("userId") String userId, @RequestBody @Validated UserUpdateRequest updatedUser) {
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
