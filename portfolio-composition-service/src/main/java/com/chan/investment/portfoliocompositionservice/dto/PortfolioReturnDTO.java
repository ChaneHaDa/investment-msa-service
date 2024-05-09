package com.chan.investment.portfoliocompositionservice.dto;

import java.util.List;

public class PortfolioReturnDTO {
    private List<PortfolioReturnItemDTO> portfolioReturnItemDTOList;

    public PortfolioReturnDTO() {
    }

    public PortfolioReturnDTO(List<PortfolioReturnItemDTO> portfolioReturnItemDTOList) {
        this.portfolioReturnItemDTOList = portfolioReturnItemDTOList;
    }

    public List<PortfolioReturnItemDTO> getPortfolioReturnItemDTOList() {
        return portfolioReturnItemDTOList;
    }

    public void setPortfolioReturnItemDTOList(List<PortfolioReturnItemDTO> portfolioReturnItemDTOList) {
        this.portfolioReturnItemDTOList = portfolioReturnItemDTOList;
    }
}
