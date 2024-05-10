package com.chan.investment.portfoliobacktestservice.dto;


import java.util.List;

public class PortfolioBacktestInputDTO {
    private String name;
    private double amount;
    private List<PortfolioBacktestInputItemDTO> portfolioItemList;

    public PortfolioBacktestInputDTO() {
    }

    public PortfolioBacktestInputDTO(String name, double amount, List<PortfolioBacktestInputItemDTO> portfolioItemList) {
        this.name = name;
        this.amount = amount;
        this.portfolioItemList = portfolioItemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<PortfolioBacktestInputItemDTO> getPortfolioItemList() {
        return portfolioItemList;
    }

    public void setPortfolioItemList(List<PortfolioBacktestInputItemDTO> portfolioItemList) {
        this.portfolioItemList = portfolioItemList;
    }
}
