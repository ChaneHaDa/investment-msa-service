package com.chan.investment.portfoliobacktestservice.service;

import com.chan.investment.portfoliobacktestservice.Wrapper.BacktestItemDTOWrapper;
import com.chan.investment.portfoliobacktestservice.dto.*;
import com.chan.investment.portfoliobacktestservice.proxy.BacktestRestProxy;
import com.chan.investment.portfoliobacktestservice.proxy.PortfolioCompositionRestProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PortfolioBacktestService {

    private final PortfolioCompositionRestProxy portfolioCompositionRestProxy;
    private final BacktestRestProxy backtestRestProxy;

    public PortfolioBacktestService(PortfolioCompositionRestProxy portfolioCompositionRestProxy, BacktestRestProxy backtestRestProxy) {
        this.portfolioCompositionRestProxy = portfolioCompositionRestProxy;
        this.backtestRestProxy = backtestRestProxy;
    }

    public PortfolioCompositionReturnDTO createPortfolio(PortfolioCompositionInputDTO portofolioCompostionInputDTO) {
        return portfolioCompositionRestProxy.createPortfolio(portofolioCompostionInputDTO);
    }

    public PortfolioBacktestReturnDTO createBacktestResult(PortfolioBacktestInputDTO portfolioBacktestInputDTO) {
        PortfolioCompositionInputDTO portfolioCompositionInputDTO = new PortfolioCompositionInputDTO(portfolioBacktestInputDTO.getPortfolioItemList());
        PortfolioCompositionReturnDTO portfolioCompositionReturnDTO = portfolioCompositionRestProxy.createPortfolio(portfolioCompositionInputDTO);
        List<PortfolioCompositionReturnItemDTO> portfolioCompositionReturnItemDTOList = portfolioCompositionReturnDTO.getPortfolioReturnItemDTOList();
        List<BacktestItemDTO> backtestItemDTOList = new ArrayList<>();
        for (PortfolioCompositionReturnItemDTO portfolioCompositionReturnItemDTO : portfolioCompositionReturnItemDTOList) {
            Map<LocalDate, Double> price = portfolioCompositionReturnItemDTO.getPrice();
            List<Double> priceList = new ArrayList<>(price.values());
            BacktestItemDTO backtestItemDTO = new BacktestItemDTO(priceList, portfolioCompositionReturnItemDTO.getWeight());
            backtestItemDTOList.add(backtestItemDTO);
        }
        BacktestItemDTOWrapper backtestItemDTOWrapper = new BacktestItemDTOWrapper(backtestItemDTOList, (long) portfolioBacktestInputDTO.getAmount());
        BacktestResultDTO backtestResultDTO = backtestRestProxy.getBacktestResult(backtestItemDTOWrapper);

        PortfolioBacktestReturnDTO portfolioBacktestReturnDTO = new PortfolioBacktestReturnDTO(portfolioBacktestInputDTO.getName(), portfolioCompositionReturnDTO, backtestResultDTO);

        return portfolioBacktestReturnDTO;
    }

}
