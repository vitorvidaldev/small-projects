package dev.vitorvidal.cameltest.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestApiConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(8000);

        from("timer:rest-api-consumer?period=10000")
                .setHeader("from", () -> "USD")
                .setHeader("to", () -> "BRL")
                .log("${body}")
                .multicast()
                .to("rest:get:/currency-exchange/from/{from}/to/{to}")
                .to("rest:post:/api/bean")
                .log("${body}");
    }
}
