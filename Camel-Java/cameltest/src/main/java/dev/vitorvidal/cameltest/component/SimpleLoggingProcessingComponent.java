package dev.vitorvidal.cameltest.component;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SimpleLoggingProcessingComponent {
    private final Logger logger = Logger.getLogger(SimpleLoggingProcessingComponent.class.getName());

    public void process(String message) {
        logger.info("SimpleLoggingProcessingComponent: " + message);
    }
}
