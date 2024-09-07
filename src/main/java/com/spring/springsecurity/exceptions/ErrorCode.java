package com.spring.springsecurity.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002, "User exists"),
    USER_NOT_EXISTED(1004, "User not exists"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters"),
    UNAUTHENTICATED(1005, "Unauthenticated")
    ;

    private Integer code;
    private String message;
}
