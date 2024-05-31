package com.chan.investment.portfolioservice.jpa.repository;

import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import com.chan.investment.portfolioservice.jpa.entity.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAllByUsername(String username);
}
