package dev.vitorvidal.threads.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vitorvidal.threads.service.AccountManagementService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/account-management")
public class AccountManagementController {
    @Autowired
    private AccountManagementService accountManagementService;

    @DeleteMapping("/{account_id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("account_id") Long accountId) {
        accountManagementService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
