package dev.vitorvidal.threads.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import dev.vitorvidal.threads.model.AccountCreationData;
import dev.vitorvidal.threads.repository.AccountRepository;

@Service
public class AccountSignupService {
    @Autowired
    private AccountRepository accountRepository;

    public void signup(AccountCreationData accountCreationData) {
        accountRepository.save(accountCreationData.toAccount());
    }

}
