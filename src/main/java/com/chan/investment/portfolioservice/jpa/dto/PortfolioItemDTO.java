package com.chan.investment.portfolioservice.jpa.dto;

import com.chan.investment.portfolioservice.jpa.entity.PortfolioItem;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PortfolioItemDTO {
    private Long id;
    @NotBlank(message = "Stock is mandatory")
    private String stock;
    @Min(value = 0, message = "Weight should be greater than 0")
    @Max(value = 1, message = "Weight should be less than 1")
    private double weight;

    public PortfolioItemDTO(){
    }

    public PortfolioItemDTO(Long id, String stock, double weight) {
        this.id = id;
        this.stock = stock;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public static PortfolioItemDTO fromEntity(PortfolioItem portfolioItem) {
        return new PortfolioItemDTO(portfolioItem.getId(), portfolioItem.getStock(), portfolioItem.getWeight());
    }

    public static PortfolioItem toEntity(PortfolioItemDTO portfolioItemDTO) {
        return new PortfolioItem(portfolioItemDTO.getId(), portfolioItemDTO.getStock(), portfolioItemDTO.getWeight(), null);
    }
}
