package com.chan.investment.securitiesservice.jpa.dto;

import com.chan.investment.securitiesservice.jpa.entity.StockInfo;

public class StockInfoDTO {
    private Long id;
    private String number;
    private String name;

    public StockInfoDTO() {
    }

    public StockInfoDTO(Long id, String number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static StockInfoDTO fromEntity(StockInfo stockinfo) {
        return new StockInfoDTO(stockinfo.getId(), stockinfo.getNumber(), stockinfo.getName());
    }

    public static StockInfo toEntity(StockInfoDTO stockinfoDTO) {
        return new StockInfo(stockinfoDTO.getId(), stockinfoDTO.getNumber(), stockinfoDTO.getName());
    }

}
