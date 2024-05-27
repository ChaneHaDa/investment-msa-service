package com.chan.investment.portfoliocompositionservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PortfolioCompositionInputItemDTO {
    @NotBlank
    private String stock;
    @Min(0)
    @Max(1)
    private double weight;

    public PortfolioCompositionInputItemDTO() {
    }

    public PortfolioCompositionInputItemDTO(String stock, double weight) {
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
