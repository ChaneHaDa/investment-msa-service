package com.chan.investment.portfolioservice.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private String username;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.REMOVE)
    private List<PortfolioItem> items;

    public Portfolio() {
    }

    public Portfolio(Long id, String name, String description, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }
}
