package com.sample.logistics.controller;

import com.sample.logistics.dto.GeneralResponse;
import com.sample.logistics.dto.LoginRequest;
import com.sample.logistics.dto.UserRequest;
import com.sample.logistics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> register(@RequestBody @Valid UserRequest user) {
        GeneralResponse response = userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
            GeneralResponse response = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(response);
    }
}