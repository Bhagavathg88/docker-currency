package com.wings2Microservices.currencyMicroservices.repository;

import com.wings2Microservices.currencyMicroservices.pojo.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange , Long> {

    public CurrencyExchange findByInputAndOutput (String input, String output);

}
