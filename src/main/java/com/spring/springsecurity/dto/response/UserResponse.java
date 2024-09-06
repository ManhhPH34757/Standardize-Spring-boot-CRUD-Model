package com.spring.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {
    private String id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDate dob;

}
