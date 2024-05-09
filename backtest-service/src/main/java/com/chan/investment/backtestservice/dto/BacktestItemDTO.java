package com.chan.investment.backtestservice.dto;

import java.util.List;

public class BacktestItemDTO {
    private List<Long> priceList;
    private double weight;

    public BacktestItemDTO() {
    }

    public BacktestItemDTO(List<Long> priceList, double weight) {
        this.priceList = priceList;
        this.weight = weight;
    }

    public List<Long> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Long> priceList) {
        this.priceList = priceList;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
