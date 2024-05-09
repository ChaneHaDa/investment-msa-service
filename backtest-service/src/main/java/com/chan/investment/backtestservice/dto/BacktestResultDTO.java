package com.chan.investment.backtestservice.dto;

import java.util.List;

public class BacktestResultDTO {

    private List<Double> rorList;
    private double totalRor;
    private double maxRor;
    private double minRor;

    public BacktestResultDTO() {
    }

    public BacktestResultDTO(List<Double> rorList, double totalRor, double maxRor, double minRor) {
        this.rorList = rorList;
        this.totalRor = totalRor;
        this.maxRor = maxRor;
        this.minRor = minRor;
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
}
