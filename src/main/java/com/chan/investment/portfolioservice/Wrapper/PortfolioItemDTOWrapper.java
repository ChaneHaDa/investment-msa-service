package com.chan.investment.portfolioservice.Wrapper;

import com.chan.investment.portfolioservice.jpa.dto.PortfolioItemDTO;
import jakarta.validation.Valid;

import java.util.List;

public class PortfolioItemDTOWrapper {

    @Valid
    private List<PortfolioItemDTO> portfolioItemDTOList;

    public PortfolioItemDTOWrapper() {
    }

    public PortfolioItemDTOWrapper(List<PortfolioItemDTO> portfolioItemDTOList) {
        this.portfolioItemDTOList = portfolioItemDTOList;
    }

    public List<PortfolioItemDTO> getPortfolioItemDTOList() {
        return portfolioItemDTOList;
    }

    public void setPortfolioItemDTOList(List<PortfolioItemDTO> portfolioItemDTOList) {
        this.portfolioItemDTOList = portfolioItemDTOList;
    }
}
