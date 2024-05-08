package com.chan.investment.portfolioservice.jpa.dto;

import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import jakarta.validation.constraints.NotBlank;

public class PortfolioDTO {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    public PortfolioDTO() {
    }
    public PortfolioDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PortfolioDTO fromEntity(Portfolio portfolio) {
        return new PortfolioDTO(portfolio.getId(), portfolio.getName());
    }

    public static Portfolio toEntity(PortfolioDTO portfolioDTO) {
        return new Portfolio(portfolioDTO.getId(), portfolioDTO.getName());
    }
}
