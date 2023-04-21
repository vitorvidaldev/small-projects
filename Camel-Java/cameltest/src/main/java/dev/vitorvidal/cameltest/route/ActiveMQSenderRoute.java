package dev.vitorvidal.cameltest.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("timer:active-mq-timer?period=1000")
//                .transform().constant("Message from ActiveMQ")
//                .log("${body}")
//                .to("activemq:my-activemq-queue");

        from("file:files/json")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
