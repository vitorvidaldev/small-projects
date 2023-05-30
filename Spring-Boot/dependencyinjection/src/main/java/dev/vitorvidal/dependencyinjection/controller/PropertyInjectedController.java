package dev.vitorvidal.dependencyinjection.controller;

import dev.vitorvidal.dependencyinjection.service.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
