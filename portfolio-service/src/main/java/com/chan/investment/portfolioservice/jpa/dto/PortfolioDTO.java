package com.chan.investment.portfolioservice.jpa.dto;

import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import jakarta.validation.constraints.NotBlank;

public class PortfolioDTO {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    public PortfolioDTO() {
    }
    public PortfolioDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PortfolioDTO fromEntity(Portfolio portfolio) {
        return new PortfolioDTO(portfolio.getId(), portfolio.getName(), portfolio.getDescription());
    }

    public static Portfolio toEntity(PortfolioDTO portfolioDTO, String username) {
        return new Portfolio(portfolioDTO.getId(), portfolioDTO.getName(), portfolioDTO.getDescription(), username);
    }
}
