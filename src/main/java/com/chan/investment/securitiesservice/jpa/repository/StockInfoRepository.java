package com.chan.investment.securitiesservice.jpa.repository;

import com.chan.investment.securitiesservice.jpa.entity.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInfoRepository extends JpaRepository<StockInfo, Long> {
    StockInfo findByName(String name);
}
