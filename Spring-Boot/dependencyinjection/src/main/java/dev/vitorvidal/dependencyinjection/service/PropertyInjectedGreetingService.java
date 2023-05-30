package dev.vitorvidal.dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world! - Property";
    }
}
