package dev.vitorvidal.cameltest.component;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimeComponent {
    public String getCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }
}