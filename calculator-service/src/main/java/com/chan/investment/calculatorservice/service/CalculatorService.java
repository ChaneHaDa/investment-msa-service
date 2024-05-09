package com.chan.investment.calculatorservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {
    public double setFormat(double value) {
        return Math.round(value * 100) / 100.0;
    }

    public <T extends Number> double getRor(T buyPrice, T sellPrice) {
        double p1 = buyPrice.doubleValue();
        double p2 = sellPrice.doubleValue();
        if(p1 == 0){
            return 0;
        }
        double ror = (p2 - p1) / p1;
        return setFormat(ror);
    }

    public <T extends Number> List<Double> getRorByList(List<T> priceList) {
        List<Double> rorList = new ArrayList<>();
        for (int i = 0; i < priceList.size() - 1; i++) {
            rorList.add(getRor(priceList.get(i), priceList.get(i + 1)));
        }
        return rorList;
    }

    public double getPortfolioRor(List<Double> rorList, List<Double> weightList){
        double portfolioRor = 0;
        for(int i = 0; i < rorList.size(); i++){
            portfolioRor += rorList.get(i) * weightList.get(i);
        }
        return this.setFormat(portfolioRor);
    }

    public double getTotalRor(List<Double> rorList){
        double totalRor = 1;
        for(Double ror : rorList){
            totalRor *= (1 + ror);
        }
        return this.setFormat(totalRor - 1);
    }

    public <T extends Number> double getAmountByRor(T Amount, double ror){
        double amount = Amount.doubleValue();
        return this.setFormat(amount * (1 + ror));
    }

}
