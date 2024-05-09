package com.chan.investment.backtestservice.proxy;

import com.chan.investment.backtestservice.dto.PortfolioRorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="calculator-service", url="localhost:8030/calculator")
public interface CalculatorRestProxy {
    @PostMapping("/ror/{sellPrice}/{buyPrice}")
    public double getRor(@PathVariable(value = "sellPrice") double sellPrice, @PathVariable(value = "buyPrice") double buyPrice);
    @PostMapping("/ror-list")
    public List<Double> getRorByList(@RequestBody List<Double> priceList);

    @PostMapping("/portfolio-ror")
    public double getPortfolioRor(@RequestBody PortfolioRorDTO portfolioRorDTO);

    @PostMapping("/total-ror")
    public double getTotalRor(@RequestBody List<Double> rorList);

    @PostMapping("/total-amount/{amount}/{ror}")
    public double getAmountByRor(@PathVariable(value = "amount") double amount, @PathVariable(value = "ror") double ror);
}