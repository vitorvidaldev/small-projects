package dev.vitorvidal.cameltest.route;

import dev.vitorvidal.cameltest.component.GetCurrentTimeComponent;
import dev.vitorvidal.cameltest.component.SimpleLoggingProcessingComponent;
import dev.vitorvidal.cameltest.processor.SimpleLogProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class TimerRoute extends RouteBuilder {
    @Autowired
    private GetCurrentTimeComponent getCurrentTimeComponent;
    @Autowired
    private SimpleLoggingProcessingComponent simpleLoggingProcessingComponent;

    @Override
    public void configure() throws Exception {
        // Camel is a integration framework

        from("timer:first-timer")
                .log("${body}")
                .transform().constant("Constant message")
                .log("${body}")
                .bean(getCurrentTimeComponent, "getCurrentTime")
                .log("${body}")
                .bean(simpleLoggingProcessingComponent)
                .process(new SimpleLogProcessor() )
                .to("log:first-timer");
    }
}