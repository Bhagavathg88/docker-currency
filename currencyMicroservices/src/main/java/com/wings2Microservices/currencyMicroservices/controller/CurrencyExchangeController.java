package com.wings2Microservices.currencyMicroservices.controller;

import com.wings2Microservices.currencyMicroservices.pojo.CurrencyExchange;
import com.wings2Microservices.currencyMicroservices.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;


@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-service/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByInputAndOutput("US", "INR");

        if(currencyExchange == null){
            throw new RuntimeException("Unable to find conversion rate for  " +from +" "+ to);
        }

        String port = environment.getProperty("local.server.port");
        String host = environment.getProperty("HOSTNAME");
        String version = "v11";
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

}
