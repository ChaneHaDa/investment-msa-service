package com.chan.investment.portfoliobacktestservice.controller;

import com.chan.investment.portfoliobacktestservice.dto.PortfolioBacktestInputDTO;
import com.chan.investment.portfoliobacktestservice.dto.PortfolioBacktestReturnDTO;
import com.chan.investment.portfoliobacktestservice.service.PortfolioBacktestService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio-backtest")
public class PortfolioBacktestController {

    private final PortfolioBacktestService portfolioBacktestService;

    public PortfolioBacktestController(PortfolioBacktestService portfolioBacktestService) {
        this.portfolioBacktestService = portfolioBacktestService;
    }

    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @PostMapping
    public PortfolioBacktestReturnDTO createPortfolio(@Valid @RequestBody PortfolioBacktestInputDTO portofolioBacktestInputDTO) {
        return portfolioBacktestService.createBacktestResult(portofolioBacktestInputDTO);
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }

}
