package dev.vitorvidal.threads.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.vitorvidal.threads.model.LoginData;
import dev.vitorvidal.threads.service.LoginService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody LoginData loginData) {
        loginService.login(loginData);
        return ResponseEntity.status(201).build();
    }
}
