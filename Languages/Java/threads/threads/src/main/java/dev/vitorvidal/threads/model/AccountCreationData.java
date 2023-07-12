package dev.vitorvidal.threads.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.vitorvidal.threads.entity.AccountEntity;

public record AccountCreationData(
                String username,
                String email,
                String password,
                @JsonProperty("password_confirmation") String passwordConfirmation,
                LocalDate birthdate) {

        public AccountEntity toAccount() {
                return null;
        }
}
