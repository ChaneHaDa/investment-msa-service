package com.chan.investment.backtestservice.proxy;

import com.chan.investment.backtestservice.dto.PortfolioRorDTO;
import com.chan.investment.backtestservice.dto.RorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="calculator-service", url="localhost:8030/calculator")
public interface CalculatorRestProxy {
    @PostMapping("/ror")
    public double getRor(@RequestBody RorDTO rorDTO);

    @PostMapping("/rors")
    public List<Double> getRorByList(@RequestBody List<Double> priceList);

    @PostMapping("/portfolio/ror")
    public double getPortfolioRor(@RequestBody PortfolioRorDTO portfolioRorDTO);

}