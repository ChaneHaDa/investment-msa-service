package com.chan.investment.portfoliobacktestservice.dto;

public class PortfolioBacktestReturnDTO {
    private String name;
    private PortfolioCompositionReturnDTO portfolioCompositionReturnDTO;
    private BacktestResultDTO backtestResultDTO;

    public PortfolioBacktestReturnDTO() {
    }

    public PortfolioBacktestReturnDTO(String name, PortfolioCompositionReturnDTO portfolioCompositionReturnDTO, BacktestResultDTO backtestResultDTO) {
        this.name = name;
        this.portfolioCompositionReturnDTO = portfolioCompositionReturnDTO;
        this.backtestResultDTO = backtestResultDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PortfolioCompositionReturnDTO getPortfolioCompositionReturnDTO() {
        return portfolioCompositionReturnDTO;
    }

    public void setPortfolioCompositionReturnDTO(PortfolioCompositionReturnDTO portfolioCompositionReturnDTO) {
        this.portfolioCompositionReturnDTO = portfolioCompositionReturnDTO;
    }

    public BacktestResultDTO getBacktestResultDTO() {
        return backtestResultDTO;
    }

    public void setBacktestResultDTO(BacktestResultDTO backtestResultDTO) {
        this.backtestResultDTO = backtestResultDTO;
    }
}
