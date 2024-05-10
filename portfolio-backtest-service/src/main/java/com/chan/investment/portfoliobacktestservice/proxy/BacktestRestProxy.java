package com.chan.investment.portfoliobacktestservice.proxy;

import com.chan.investment.portfoliobacktestservice.Wrapper.BacktestItemDTOWrapper;
import com.chan.investment.portfoliobacktestservice.dto.BacktestResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="backtest-service", url="localhost:8020/backtest")
public interface BacktestRestProxy {
    @PostMapping
    public BacktestResultDTO getBacktestResult(@RequestBody BacktestItemDTOWrapper backtestItemDTOWrapper);

}
