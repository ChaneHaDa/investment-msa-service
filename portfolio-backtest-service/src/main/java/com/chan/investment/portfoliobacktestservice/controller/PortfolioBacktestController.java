package com.chan.investment.portfoliobacktestservice.controller;

import com.chan.investment.portfoliobacktestservice.dto.PortfolioBacktestInputDTO;
import com.chan.investment.portfoliobacktestservice.dto.PortfolioBacktestReturnDTO;
import com.chan.investment.portfoliobacktestservice.proxy.BacktestRestProxy;
import com.chan.investment.portfoliobacktestservice.service.PortfolioBacktestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio-backtest")
public class PortfolioBacktestController {

    private final PortfolioBacktestService portfolioBacktestService;
    private final BacktestRestProxy backtestRestProxy;

    public PortfolioBacktestController(PortfolioBacktestService portfolioBacktestService, BacktestRestProxy backtestRestProxy) {
        this.portfolioBacktestService = portfolioBacktestService;
        this.backtestRestProxy = backtestRestProxy;
    }

    @PostMapping
    public PortfolioBacktestReturnDTO createPortfolio(@RequestBody PortfolioBacktestInputDTO portofolioBacktestInputDTO) {
        return portfolioBacktestService.createBacktestResult(portofolioBacktestInputDTO);
    }

}