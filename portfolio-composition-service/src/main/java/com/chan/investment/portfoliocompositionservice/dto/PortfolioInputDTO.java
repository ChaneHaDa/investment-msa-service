package com.chan.investment.portfoliocompositionservice.dto;

import java.util.List;

public class PortfolioInputDTO {
    private List<PortfolioInputItemDTO> portfolioItemList;

    public PortfolioInputDTO() {
    }

    public PortfolioInputDTO(List<PortfolioInputItemDTO> portfolioItemList) {
        this.portfolioItemList = portfolioItemList;
    }

    public List<PortfolioInputItemDTO> getItems() {
        return portfolioItemList;
    }

    public void setItems(List<PortfolioInputItemDTO> items) {
        this.portfolioItemList = items;
    }
}
