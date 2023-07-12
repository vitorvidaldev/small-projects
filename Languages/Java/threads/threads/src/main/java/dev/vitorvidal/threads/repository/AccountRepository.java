package dev.vitorvidal.threads.repository;

import org.springframework.stereotype.Repository;

import dev.vitorvidal.threads.entity.AccountEntity;

@Repository
public interface AccountRepository {

    void save(AccountEntity account);

    void deleteById(Long accountId);

    void findByUsernameAndPassword(String username, String password);

}
