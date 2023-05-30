package dev.vitorvidal.dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class SetterInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world! - Setter";
    }
}
