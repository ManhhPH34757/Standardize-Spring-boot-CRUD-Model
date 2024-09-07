package com.spring.springsecurity.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateRequest {

    @Size(min = 6, message = "PASSWORD_INVALID")
    private String password;

    private String firstName;

    private String lastName;

    private LocalDate dob;
}
