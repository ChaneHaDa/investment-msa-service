package com.chan.investment.portfolioservice.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stock;

    @Column(nullable = false)
    private double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Portfolio portfolio;

    public PortfolioItem() {
    }

    public PortfolioItem(Long id, String stock, double weight, Portfolio portfolio) {
        this.id = id;
        this.stock = stock;
        this.weight = weight;
        this.portfolio = portfolio;
    }

    public Long getId() {
        return id;
    }

    public String getStock() {
        return stock;
    }

    public double getWeight() {
        return weight;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
