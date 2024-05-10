package com.chan.investment.portfoliobacktestservice.dto;

import java.time.LocalDate;
import java.util.Map;

public class PortfolioCompositionReturnItemDTO {
    private String stock;
    private Map<LocalDate, Double> price;
    private double weight;

    public PortfolioCompositionReturnItemDTO() {
    }

    public PortfolioCompositionReturnItemDTO(String stock, Map<LocalDate, Double> price, double weight) {
        this.stock = stock;
        this.price = price;
        this.weight = weight;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Map<LocalDate, Double> getPrice() {
        return price;
    }

    public void setPrice(Map<LocalDate, Double> price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}