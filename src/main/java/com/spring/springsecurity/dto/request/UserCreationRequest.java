package com.spring.springsecurity.dto.request;

import com.spring.springsecurity.exceptions.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreationRequest {

    private String email;

    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;

    private String firstName;

    private String lastName;

    private LocalDate dob;

}
