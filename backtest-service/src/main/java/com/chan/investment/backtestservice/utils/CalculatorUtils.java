package com.chan.investment.backtestservice.utils;

import java.util.ArrayList;
import java.util.List;

public class CalculatorUtils {
    public static double setFormat(double value) {
        return Math.round(value * 100) / 100.0;
    }

    public static <T extends Number> double getRor(T buyPrice, T sellPrice) {
        double p1 = buyPrice.doubleValue();
        double p2 = sellPrice.doubleValue();
        if(p1 == 0){
            return 0;
        }
        double ror = (p2 - p1) / p1;
        return setFormat(ror);
    }

    public static <T extends Number> List<Double> getRorByList(List<T> priceList) {
        List<Double> rorList = new ArrayList<>();
        for (int i = 0; i < priceList.size() - 1; i++) {
            rorList.add(getRor(priceList.get(i), priceList.get(i + 1)));
        }
        return rorList;
    }

    public static double getPortfolioRor(List<Double> rorList, List<Double> weightList){
        double portfolioRor = 0;
        for(int i = 0; i < rorList.size(); i++){
            portfolioRor += rorList.get(i) * weightList.get(i);
        }
        return setFormat(portfolioRor);
    }

    public static double getTotalRor(List<Double> rorList){
        double totalRor = 1;
        for(Double ror : rorList){
            totalRor *= (1 + ror);
        }
        return setFormat(totalRor - 1);
    }

    public static <T extends Number> double getAmountByRor(T Amount, double ror){
        double amount = Amount.doubleValue();
        return setFormat(amount * (1 + ror));
    }

}
