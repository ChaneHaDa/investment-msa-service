package com.chan.investment.portfoliocompositionservice.dto;

import java.time.LocalDate;

public class StockPriceDTO {
    private String number;
    private double price;
    private LocalDate date;

    public StockPriceDTO() {
    }

    public StockPriceDTO(String number, double price, LocalDate date) {
        this.number = number;
        this.price = price;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
