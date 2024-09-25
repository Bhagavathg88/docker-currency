package com.wings2Microservices.currencyMicroservices.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class CurrencyExchange {
    @Id
    private Long id;
    private String input;
    private String output;
    private BigDecimal exchangeValue;

    private String environment;

    public CurrencyExchange(Long id, String input, String output, BigDecimal exchangeValue) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.exchangeValue = exchangeValue;
    }

    public CurrencyExchange() {
    }
}
