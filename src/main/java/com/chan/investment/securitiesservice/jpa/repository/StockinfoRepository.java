package com.chan.investment.securitiesservice.jpa.repository;

import com.chan.investment.securitiesservice.jpa.entity.Stockinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockinfoRepository extends JpaRepository<Stockinfo, Long> {
    Stockinfo findByName(String name);
}
