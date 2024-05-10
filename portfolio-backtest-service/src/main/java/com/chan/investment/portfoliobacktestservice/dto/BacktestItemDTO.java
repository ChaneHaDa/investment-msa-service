package com.chan.investment.portfoliobacktestservice.dto;

import java.util.List;

public class BacktestItemDTO {
    private List<Double> priceList;
    private double weight;

    public BacktestItemDTO() {
    }

    public BacktestItemDTO(List<Double> priceList, double weight) {
        this.priceList = priceList;
        this.weight = weight;
    }

    public List<Double> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Double> priceList) {
        this.priceList = priceList;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

