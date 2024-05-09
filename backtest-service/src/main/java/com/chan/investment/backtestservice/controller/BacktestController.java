package com.chan.investment.backtestservice.controller;

import com.chan.investment.backtestservice.dto.BacktestResultDTO;
import com.chan.investment.backtestservice.proxy.CalculatorRestProxy;
import com.chan.investment.backtestservice.service.BacktestService;
import com.chan.investment.backtestservice.wrapper.BacktestItemDTOWrapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backtest")
public class BacktestController {

    private final BacktestService backtestService;
    private final CalculatorRestProxy calculatorRestProxy;

    public BacktestController(BacktestService backtestService, CalculatorRestProxy calculatorRestProxy) {
        this.backtestService = backtestService;
        this.calculatorRestProxy = calculatorRestProxy;
    }

    @PostMapping
    public BacktestResultDTO getBacktestResult(@RequestBody BacktestItemDTOWrapper backtestItemDTOWrapper) {
        return backtestService.getBacktestResult(backtestItemDTOWrapper);
    }

}
