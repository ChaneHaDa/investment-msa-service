package com.chan.investment.backtestservice.service;

import com.chan.investment.backtestservice.dto.BacktestItemDTO;
import com.chan.investment.backtestservice.dto.BacktestResultDTO;
import com.chan.investment.backtestservice.wrapper.BacktestItemDTOWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BacktestService {
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

    public double getPortfolioRor(List<Double> rorList, List<Double> weightList){
        double portfolioRor = 0;
        for(int i = 0; i < rorList.size(); i++){
            portfolioRor += rorList.get(i) * weightList.get(i);
        }
        return this.setFormat(portfolioRor);
    }

    public List<Double> getPortfolioRorList(List<List<Double>> rorList, List<Double> weightList){
        List<Double> portfolioRorList = new ArrayList<>();
        for(int i = 0; i < rorList.get(0).size(); i++){
            double portfolioRor = 0;
            for(int j = 0; j < rorList.size(); j++){
                portfolioRor += rorList.get(j).get(i) * weightList.get(j);
            }
            portfolioRorList.add(this.setFormat(portfolioRor));
        }
        return portfolioRorList;
    }

    public List<Long> getAmountByRorList(List<Double> rorList, long amount){
        List<Long> cashList = new ArrayList<>();
        cashList.add(amount);
        for(int i = 0; i < rorList.size(); i++){
            cashList.add((long) (cashList.get(i) * (1 + rorList.get(i) / 100)));
        }
        return cashList;
    }

    public Double getTotalRor(List<Double> rorList) {
        Double totalRor = 1.0;
        for(int i = 0; i < rorList.size(); i++){
            totalRor *= (1 + rorList.get(i) / 100);
        }
        totalRor -= 1;

        return this.setFormat(totalRor * 100);
    }

    public BacktestResultDTO getBacktestResult(BacktestItemDTOWrapper backtestItemDTOWrapper){
        List<BacktestItemDTO> backtestItemDTOList = backtestItemDTOWrapper.getBacktestItemDTOList();
        long amount = backtestItemDTOWrapper.getAmount();

        List<List<Double>> rorList = new ArrayList<>();
        List<Double> weightList = new ArrayList<>();

        for(BacktestItemDTO backtestItemDTO : backtestItemDTOList){
            List<Long> priceList = backtestItemDTO.getPriceList();
            double weight = backtestItemDTO.getWeight();
            List<Double> ror = getRorByList(priceList);
            rorList.add(ror);
            weightList.add(weight);
        }

        List<Double> portfolioRorList = getPortfolioRorList(rorList, weightList);
        double totalRor = getTotalRor(portfolioRorList);
        double maxRor = portfolioRorList.stream().max(Double::compare).get();
        double minRor = portfolioRorList.stream().min(Double::compare).get();

        return new BacktestResultDTO(portfolioRorList, totalRor, maxRor, minRor);
    }

}
