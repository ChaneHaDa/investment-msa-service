package com.chan.investment.securitiesservice.jpa.dto;

import com.chan.investment.securitiesservice.jpa.entity.StockPrice;

import java.time.LocalDate;

public class StockPriceDTO {
    private Long id;
    private String number;
    private long price;
    private LocalDate date;

    public StockPriceDTO() {
    }

    public StockPriceDTO(Long id, String number, long price, LocalDate date) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static StockPriceDTO fromEntity(StockPrice stockPrice) {
        return new StockPriceDTO(stockPrice.getId(), stockPrice.getNumber(), stockPrice.getPrice(), stockPrice.getDate());
    }

    public static StockPrice toEntity(StockPriceDTO stockPriceDTO) {
        return new StockPrice(stockPriceDTO.getId(), stockPriceDTO.getNumber(), stockPriceDTO.getPrice(), stockPriceDTO.getDate());
    }

}
