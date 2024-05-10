package com.chan.investment.portfoliobacktestservice.dto;

import java.util.List;

public class BacktestResultDTO {

    private List<List<Double>> itemRorList;
    private List<Double> rorList;
    private double totalRor;
    private double maxRor;
    private double minRor;
    private double amount;

    public BacktestResultDTO() {
    }

    public BacktestResultDTO(List<List<Double>> itemRorList, List<Double> rorList, double totalRor, double maxRor, double minRor, double amount) {
        this.itemRorList = itemRorList;
        this.rorList = rorList;
        this.totalRor = totalRor;
        this.maxRor = maxRor;
        this.minRor = minRor;
        this.amount = amount;
    }

    public List<Double> getRorList() {
        return rorList;
    }

    public void setRorList(List<Double> rorList) {
        this.rorList = rorList;
    }

    public double getTotalRor() {
        return totalRor;
    }

    public void setTotalRor(double totalRor) {
        this.totalRor = totalRor;
    }

    public double getMaxRor() {
        return maxRor;
    }

    public void setMaxRor(double maxRor) {
        this.maxRor = maxRor;
    }

    public double getMinRor() {
        return minRor;
    }

    public void setMinRor(double minRor) {
        this.minRor = minRor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<List<Double>> getItemRorList() {
        return itemRorList;
    }

    public void setItemRorList(List<List<Double>> itemRorList) {
        this.itemRorList = itemRorList;
    }
}
