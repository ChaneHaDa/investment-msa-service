package com.chan.investment.portfoliocompositionservice.controller;

import com.chan.investment.portfoliocompositionservice.dto.PortfolioInputDTO;
import com.chan.investment.portfoliocompositionservice.dto.PortfolioReturnDTO;
import com.chan.investment.portfoliocompositionservice.service.PortfolioCompostionService;
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
    public PortfolioReturnDTO createPortfolio(@RequestBody PortfolioInputDTO portfolioInputDTO) {
        return portfolioCompostionService.getPortfolioReturn(portfolioInputDTO);
    }
}
