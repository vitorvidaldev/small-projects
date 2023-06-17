package dev.vitorvidal.cameltest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLogProcessor implements Processor {
    private final Logger logger = LoggerFactory.getLogger(SimpleLogProcessor.class);


    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("SimpleLoggingProcessor {}", exchange.getMessage().getBody());
    }
}
