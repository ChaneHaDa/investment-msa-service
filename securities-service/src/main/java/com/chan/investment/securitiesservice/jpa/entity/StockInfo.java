package com.chan.investment.securitiesservice.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stock_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"number", "name"})})
public class StockInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String name;

    public StockInfo() {
    }

    public StockInfo(Long id, String number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

}
