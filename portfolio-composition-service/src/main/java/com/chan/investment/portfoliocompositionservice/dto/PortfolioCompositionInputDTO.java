package com.chan.investment.portfoliocompositionservice.dto;

import java.util.List;

public class PortfolioCompositionInputDTO {
    private List<PortfolioCompositionInputItemDTO> portfolioItemList;

    public PortfolioCompositionInputDTO() {
    }

    public PortfolioCompositionInputDTO(List<PortfolioCompositionInputItemDTO> portfolioItemList) {
        this.portfolioItemList = portfolioItemList;
    }

    public List<PortfolioCompositionInputItemDTO> getPortfolioItemList() {
        return portfolioItemList;
    }

    public void setPortfolioItemList(List<PortfolioCompositionInputItemDTO> portfolioItemList) {
        this.portfolioItemList = portfolioItemList;
    }
}
