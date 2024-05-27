package com.chan.investment.portfoliocompositionservice.dto;

import jakarta.validation.Valid;

import java.util.List;

public class PortfolioCompositionInputDTO {
    @Valid
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
