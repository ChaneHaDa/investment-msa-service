package com.chan.investment.portfoliocompositionservice.controller;

import com.chan.investment.portfoliocompositionservice.dto.PortfolioCompositionInputDTO;
import com.chan.investment.portfoliocompositionservice.dto.PortfolioCompositionReturnDTO;
import com.chan.investment.portfoliocompositionservice.service.PortfolioCompostionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio-composition")
public class PortfolioCompostionController {

    private final PortfolioCompostionService portfolioCompostionService;

    public PortfolioCompostionController(PortfolioCompostionService portfolioCompostionService) {
        this.portfolioCompostionService = portfolioCompostionService;
    }

    @PostMapping
    @CircuitBreaker(name = "default", fallbackMethod = "createPortfolioFallback")
    public PortfolioCompositionReturnDTO createPortfolio(@Valid @RequestBody PortfolioCompositionInputDTO portfolioCompositionInputDTO) {

        return portfolioCompostionService.getPortfolioReturn(portfolioCompositionInputDTO);
    }

    public PortfolioCompositionReturnDTO createPortfolioFallback(@Valid @RequestBody PortfolioCompositionInputDTO portfolioCompositionInputDTO) {
        throw new RuntimeException("Service is down");
    }
}
