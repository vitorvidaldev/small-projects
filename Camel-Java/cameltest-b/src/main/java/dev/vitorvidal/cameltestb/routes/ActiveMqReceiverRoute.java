package dev.vitorvidal.cameltestb.routes;

import dev.vitorvidal.cameltestb.component.MyCurrencyExchangeProcessor;
import dev.vitorvidal.cameltestb.model.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqReceiverRoute extends RouteBuilder {
    @Autowired
    MyCurrencyExchangeProcessor myCurrencyExchangeProcessor = new MyCurrencyExchangeProcessor();

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(myCurrencyExchangeProcessor)
                .to("log:received-message-from-active-mq");
    }
}
