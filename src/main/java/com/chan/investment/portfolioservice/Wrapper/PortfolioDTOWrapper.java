package com.chan.investment.portfolioservice.Wrapper;

import com.chan.investment.portfolioservice.jpa.dto.PortfolioDTO;
import jakarta.validation.Valid;

import java.util.List;

public class PortfolioDTOWrapper {
    @Valid
    private List<PortfolioDTO> portfolioDTOList;

    public PortfolioDTOWrapper() {
    }

    public PortfolioDTOWrapper(List<PortfolioDTO> portfolioDTOList) {
        this.portfolioDTOList = portfolioDTOList;
    }

    public List<PortfolioDTO> getPortfolioDTOList() {
        return portfolioDTOList;
    }

    public void setPortfolioDTOList(List<PortfolioDTO> portfolioDTOList) {
        this.portfolioDTOList = portfolioDTOList;
    }
}
