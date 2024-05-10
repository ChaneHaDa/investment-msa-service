package com.chan.investment.portfoliocompositionservice.service;

import com.chan.investment.portfoliocompositionservice.dto.*;
import com.chan.investment.portfoliocompositionservice.proxy.SecuritiesRestProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PortfolioCompostionService {

    private final SecuritiesRestProxy securitiesRestProxy;

    public PortfolioCompostionService(SecuritiesRestProxy securitiesRestProxy) {
        this.securitiesRestProxy = securitiesRestProxy;
    }

    public void validPortfolioInput(PortfolioCompositionInputDTO portfolioCompositionInputDTO) {
        double sum = 0;
        for (PortfolioCompositionInputItemDTO portfolioCompositionInputItemDTO : portfolioCompositionInputDTO.getPortfolioItemList()) {
            sum += portfolioCompositionInputItemDTO.getWeight();
        }
        if(sum != 1) {
            throw new IllegalArgumentException("Sum of weights should be 1");
        }
    }

    public PortfolioCompositionReturnItemDTO getPortfolioReturnItem(String stock, double weight) {
        List<StockPriceDTO> stockPriceDTOList = securitiesRestProxy.getStockPrices(stock);
        Map<LocalDate, Double> price = stockPriceDTOList.stream().collect(Collectors.toMap(StockPriceDTO::getDate, StockPriceDTO::getPrice));
        return new PortfolioCompositionReturnItemDTO(stock, price, weight);
    }

    public PortfolioCompositionReturnDTO getPortfolioReturn(PortfolioCompositionInputDTO portfolioCompositionInputDTO) {
        this.validPortfolioInput(portfolioCompositionInputDTO);
        List<PortfolioCompositionReturnItemDTO> portfolioCompositionReturnItemDTOList = new ArrayList<>();
        for (PortfolioCompositionInputItemDTO portfolioCompositionInputItemDTO : portfolioCompositionInputDTO.getPortfolioItemList()) {
            PortfolioCompositionReturnItemDTO portfolioCompositionReturnItemDTO = getPortfolioReturnItem(portfolioCompositionInputItemDTO.getStock(), portfolioCompositionInputItemDTO.getWeight());
            portfolioCompositionReturnItemDTOList.add(portfolioCompositionReturnItemDTO);
        }
        return new PortfolioCompositionReturnDTO(portfolioCompositionReturnItemDTOList);
    }

}
