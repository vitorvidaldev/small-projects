package dev.vitorvidal.threads.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import dev.vitorvidal.threads.model.LoginData;
import dev.vitorvidal.threads.repository.AccountRepository;

@Service
public class LoginService {

    @Autowired
    private AccountRepository accountRepository;

    public void login(LoginData loginData) {
        accountRepository.findByUsernameAndPassword(loginData.email(), loginData.password());
    }
}
