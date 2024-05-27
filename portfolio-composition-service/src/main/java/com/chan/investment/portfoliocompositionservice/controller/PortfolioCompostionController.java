package com.chan.investment.portfoliocompositionservice.controller;

import com.chan.investment.portfoliocompositionservice.dto.PortfolioCompositionInputDTO;
import com.chan.investment.portfoliocompositionservice.dto.PortfolioCompositionReturnDTO;
import com.chan.investment.portfoliocompositionservice.service.PortfolioCompostionService;
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
    public PortfolioCompositionReturnDTO createPortfolio(@Valid @RequestBody PortfolioCompositionInputDTO portfolioCompositionInputDTO) {
        return portfolioCompostionService.getPortfolioReturn(portfolioCompositionInputDTO);
    }
}
