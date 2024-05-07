package com.chan.investment.securitiesservice.jpa.dto;

import com.chan.investment.securitiesservice.jpa.entity.Stockinfo;

public class StockinfoDTO {
    private Long id;
    private String number;
    private String name;

    public StockinfoDTO() {
    }

    public StockinfoDTO(Long id, String number, String name) {
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

    public static StockinfoDTO fromEntity(Stockinfo stockinfo) {
        return new StockinfoDTO(stockinfo.getId(), stockinfo.getNumber(), stockinfo.getName());
    }

    public static Stockinfo toEntity(StockinfoDTO stockinfoDTO) {
        return new Stockinfo(stockinfoDTO.getId(), stockinfoDTO.getNumber(), stockinfoDTO.getName());
    }

}
