package com.chan.investment.portfoliocompositionservice.dto;

import java.util.List;

public class PortfolioCompositionReturnDTO {
    private List<PortfolioCompositionReturnItemDTO> portfolioCompositionReturnItemDTOList;

    public PortfolioCompositionReturnDTO() {
    }

    public PortfolioCompositionReturnDTO(List<PortfolioCompositionReturnItemDTO> portfolioCompositionReturnItemDTOList) {
        this.portfolioCompositionReturnItemDTOList = portfolioCompositionReturnItemDTOList;
    }

    public List<PortfolioCompositionReturnItemDTO> getPortfolioReturnItemDTOList() {
        return portfolioCompositionReturnItemDTOList;
    }

    public void setPortfolioReturnItemDTOList(List<PortfolioCompositionReturnItemDTO> portfolioCompositionReturnItemDTOList) {
        this.portfolioCompositionReturnItemDTOList = portfolioCompositionReturnItemDTOList;
    }
}
