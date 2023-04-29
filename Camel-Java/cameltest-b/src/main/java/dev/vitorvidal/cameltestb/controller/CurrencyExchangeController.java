package dev.vitorvidal.cameltestb.controller;

import dev.vitorvidal.cameltestb.model.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange findConversionValue(@PathVariable String from, @PathVariable String to) {
        return new CurrencyExchange(1000L, "USD", "BRL", BigDecimal.TEN);
    }
}
