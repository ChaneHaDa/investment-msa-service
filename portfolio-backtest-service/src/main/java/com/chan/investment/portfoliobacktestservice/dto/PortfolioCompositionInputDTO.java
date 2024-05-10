package com.chan.investment.portfoliobacktestservice.dto;

import java.util.List;

public class PortfolioCompositionInputDTO {
    private List<PortfolioBacktestInputItemDTO> portfolioItemList;

    public PortfolioCompositionInputDTO() {
    }

    public PortfolioCompositionInputDTO(List<PortfolioBacktestInputItemDTO> portfolioItemList) {
        this.portfolioItemList = portfolioItemList;
    }

    public List<PortfolioBacktestInputItemDTO> getPortfolioItemList() {
        return portfolioItemList;
    }

    public void setPortfolioItemList(List<PortfolioBacktestInputItemDTO> portfolioItemList) {
        this.portfolioItemList = portfolioItemList;
    }
}
