package com.chan.investment.calculatorservice.controller;

import com.chan.investment.calculatorservice.dto.PortfolioRorDTO;
import com.chan.investment.calculatorservice.dto.RorDTO;
import com.chan.investment.calculatorservice.service.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/ror")
    public double getRor(@RequestBody RorDTO rorDTO) {
        double buyPrice = rorDTO.getBuyPrice();
        double sellPrice = rorDTO.getSellPrice();
        return calculatorService.getRor(buyPrice, sellPrice);
    }

    @PostMapping("/rors")
    public List<Double> getRorByList(@RequestBody List<Double> priceList) {
        return calculatorService.getRorByList(priceList);
    }

    @PostMapping("/portfolio/ror")
    public double getPortfolioRor(@RequestBody PortfolioRorDTO portfolioRorDTO) {
        List<Double> rorList = portfolioRorDTO.getRorList();
        List<Double> weightList = portfolioRorDTO.getWeightList();
        return calculatorService.getPortfolioRor(rorList, weightList);
    }

}
