package com.chan.investment.backtestservice.proxy;

import com.chan.investment.backtestservice.dto.PortfolioRorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="calculator-service")
public interface CalculatorRestProxy {
    @PostMapping("/calculator/ror/{sellPrice}/{buyPrice}")
    public double getRor(@PathVariable(value = "sellPrice") double sellPrice, @PathVariable(value = "buyPrice") double buyPrice);
    @PostMapping("/calculator/ror-list")
    public List<Double> getRorByList(@RequestBody List<Double> priceList);

    @PostMapping("/calculator/portfolio-ror")
    public double getPortfolioRor(@RequestBody PortfolioRorDTO portfolioRorDTO);

    @PostMapping("/calculator/total-ror")
    public double getTotalRor(@RequestBody List<Double> rorList);

    @PostMapping("/calculator/total-amount/{amount}/{ror}")
    public double getAmountByRor(@PathVariable(value = "amount") double amount, @PathVariable(value = "ror") double ror);
}