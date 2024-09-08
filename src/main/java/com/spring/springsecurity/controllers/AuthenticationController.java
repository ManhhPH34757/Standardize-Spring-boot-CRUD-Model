package com.spring.springsecurity.controllers;

import com.nimbusds.jose.JOSEException;
import com.spring.springsecurity.dto.request.AuthenticationRequest;
import com.spring.springsecurity.dto.request.IntrospectRequest;
import com.spring.springsecurity.dto.response.ApiResponse;
import com.spring.springsecurity.dto.response.AuthenticationResponse;
import com.spring.springsecurity.dto.response.IntrospectResponse;
import com.spring.springsecurity.services.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request){
        var result = authenticationService.authenticated(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> introspectToken(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspectResponse(request);

        return ApiResponse.<IntrospectResponse>builder()
               .result(result)
               .build();
    }
}
