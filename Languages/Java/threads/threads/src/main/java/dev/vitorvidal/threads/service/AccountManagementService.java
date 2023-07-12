package dev.vitorvidal.threads.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import dev.vitorvidal.threads.repository.AccountRepository;

@Service
public class AccountManagementService {
    @Autowired
    private AccountRepository accountRepository;

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

}
