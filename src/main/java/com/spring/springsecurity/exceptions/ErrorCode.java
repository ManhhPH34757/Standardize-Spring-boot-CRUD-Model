package com.spring.springsecurity.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, HttpStatus.INTERNAL_SERVER_ERROR, "Uncategorized error"),
    INVALID_KEY(1001, HttpStatus.BAD_REQUEST, "Invalid message key"),
    USER_EXISTED(1002, HttpStatus.BAD_REQUEST, "User exists"),
    USER_NOT_EXISTED(1003, HttpStatus.NOT_FOUND, "User not exists"),
    PASSWORD_INVALID(1004, HttpStatus.BAD_REQUEST, "Password must be at least 6 characters"),
    UNAUTHENTICATED(1005, HttpStatus.UNAUTHORIZED, "Unauthenticated"),
    PRODUCT_NOT_EXIST(1006, HttpStatus.BAD_REQUEST, "Product not exists"),
    UNAUTHORIZED(1007, HttpStatus.FORBIDDEN, "You don't have permission" );

    private Integer code;
    private HttpStatus statusCode;
    private String message;

}
