package com.chan.investment.portfoliobacktestservice.dto;

public class PortfolioBacktestInputItemDTO {
    private String stock;
    private double weight;

    public PortfolioBacktestInputItemDTO() {
    }

    public PortfolioBacktestInputItemDTO(String stock, double weight) {
        this.stock = stock;
        this.weight = weight;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
