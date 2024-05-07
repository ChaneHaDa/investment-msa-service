package com.chan.investment.securitiesservice.jpa.repository;

import com.chan.investment.securitiesservice.jpa.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
    List<StockPrice> findByNumber(String number);
}
