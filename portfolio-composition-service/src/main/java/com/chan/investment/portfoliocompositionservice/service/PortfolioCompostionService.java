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

    public void validPortfolioInput(PortfolioInputDTO portfolioInputDTO) {
        double sum = 0;
        for (PortfolioInputItemDTO portfolioInputItemDTO : portfolioInputDTO.getItems()) {
            sum += portfolioInputItemDTO.getWeight();
        }
        if(sum != 1) {
            throw new IllegalArgumentException("Sum of weights should be 1");
        }
    }

    public PortfolioReturnItemDTO getPortfolioReturnItem(String stock, double weight) {
        List<StockPriceDTO> stockPriceDTOList = securitiesRestProxy.getStockPrices(stock);
        Map<LocalDate, Double> price = stockPriceDTOList.stream().collect(Collectors.toMap(StockPriceDTO::getDate, StockPriceDTO::getPrice));
        return new PortfolioReturnItemDTO(stock, price, weight);
    }

    public PortfolioReturnDTO getPortfolioReturn(PortfolioInputDTO portfolioInputDTO) {
        this.validPortfolioInput(portfolioInputDTO);
        List<PortfolioReturnItemDTO> portfolioReturnItemDTOList = new ArrayList<>();
        for (PortfolioInputItemDTO portfolioInputItemDTO : portfolioInputDTO.getItems()) {
            PortfolioReturnItemDTO portfolioReturnItemDTO = getPortfolioReturnItem(portfolioInputItemDTO.getStock(), portfolioInputItemDTO.getWeight());
            portfolioReturnItemDTOList.add(portfolioReturnItemDTO);
        }
        return new PortfolioReturnDTO(portfolioReturnItemDTOList);
    }

}
