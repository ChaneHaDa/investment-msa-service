package com.chan.investment.backtestservice.service;

import com.chan.investment.backtestservice.dto.BacktestItemDTO;
import com.chan.investment.backtestservice.dto.BacktestResultDTO;
import com.chan.investment.backtestservice.proxy.CalculatorRestProxy;
import com.chan.investment.backtestservice.wrapper.BacktestItemDTOWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BacktestService {

    private final CalculatorRestProxy calculatorRestProxy;

    public BacktestService(CalculatorRestProxy calculatorRestProxy) {
        this.calculatorRestProxy = calculatorRestProxy;
    }

    public double setFormat(double value) {
        return Math.round(value * 100) / 100.0;
    }

    public <T extends Number> double getRor(T price1, T price2) {
        double p1 = price1.doubleValue();
        double p2 = price2.doubleValue();
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

//    public BacktestResultDTO getBacktestResult(BacktestItemDTOWrapper backtestItemDTOWrapper){
//        List<BacktestItemDTO> backtestItemDTOList = backtestItemDTOWrapper.getBacktestItemDTOList();
//        long amount = backtestItemDTOWrapper.getAmount();
//        return new BacktestResultDTO(portfolioRorList, totalRor, maxRor, minRor);
//    }

}
