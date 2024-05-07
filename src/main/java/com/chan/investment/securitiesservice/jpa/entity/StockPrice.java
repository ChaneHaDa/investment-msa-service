package com.chan.investment.securitiesservice.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private long price;
    private LocalDate date;

    public StockPrice() {
    }

    public StockPrice(Long id, String number, long price, LocalDate date) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }
}
