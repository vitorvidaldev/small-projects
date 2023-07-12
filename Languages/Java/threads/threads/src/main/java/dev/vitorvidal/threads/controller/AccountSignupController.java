package dev.vitorvidal.threads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vitorvidal.threads.model.AccountCreationData;
import dev.vitorvidal.threads.service.AccountSignupService;

@RestController
@RequestMapping("/signup")
public class AccountSignupController {
    @Autowired
    private AccountSignupService accountSignupService;

    @PostMapping
    public ResponseEntity<Void> signup(@RequestBody AccountCreationData accountCreationData) {
        accountSignupService.signup(accountCreationData);
        return ResponseEntity.status(201).build();
    }
}
