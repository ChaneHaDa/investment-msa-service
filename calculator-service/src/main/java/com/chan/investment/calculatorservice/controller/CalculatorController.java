package com.chan.investment.calculatorservice.controller;

import com.chan.investment.calculatorservice.dto.PortfolioRorDTO;
import com.chan.investment.calculatorservice.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/ror/{sellPrice}/{buyPrice}")
    public double getRor(@PathVariable(value = "sellPrice") double sellPrice, @PathVariable(value = "buyPrice") double buyPrice) {
        return calculatorService.getRor(buyPrice, sellPrice);
    }

    @PostMapping("/ror-list")
    public List<Double> getRorByList(@RequestBody List<Double> priceList) {
        return calculatorService.getRorByList(priceList);
    }

    @PostMapping("/portfolio-ror")
    public double getPortfolioRor(@RequestBody PortfolioRorDTO portfolioRorDTO) {
        List<Double> rorList = portfolioRorDTO.getRorList();
        List<Double> weightList = portfolioRorDTO.getWeightList();
        return calculatorService.getPortfolioRor(rorList, weightList);
    }

    @PostMapping("/total-ror")
    public double getTotalRor(@RequestBody List<Double> rorList) {
        return calculatorService.getTotalRor(rorList);
    }

    @PostMapping("/total-amount/{amount}/{ror}")
    public double getAmountByRor(@PathVariable(value = "amount") double amount, @PathVariable(value = "ror") double ror) {
        return calculatorService.getAmountByRor(amount, ror);
    }
}
