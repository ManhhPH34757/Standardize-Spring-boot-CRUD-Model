package com.spring.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateRequest {

    private String password;

    private String firstName;

    private String lastName;

    private LocalDate dob;
}
