package com.chan.investment.securitiesservice.jpa.service;

import com.chan.investment.securitiesservice.exception.EntityNotFoundException;
import com.chan.investment.securitiesservice.jpa.dto.StockPriceDTO;
import com.chan.investment.securitiesservice.jpa.dto.StockinfoDTO;
import com.chan.investment.securitiesservice.jpa.entity.StockPrice;
import com.chan.investment.securitiesservice.jpa.repository.StockPriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockPriceService {

    private final StockPriceRepository stockPriceRepository;

    public StockPriceService(StockPriceRepository stockPriceRepository) {
        this.stockPriceRepository = stockPriceRepository;
    }

    public List<StockPriceDTO> getStockPricesByNumber(String number) {
        List<StockPrice> stockPrices = stockPriceRepository.findByNumber(number);
        if(stockPrices.isEmpty()){
            throw new EntityNotFoundException("StockPrice not found");
        }
        List<StockPriceDTO> stockPriceDTOs = stockPrices.stream().map(StockPriceDTO::fromEntity).collect(Collectors.toList());
        return stockPriceDTOs;
    }

    public List<StockPriceDTO> getStockPrices() {
        List<StockPrice> stockPrices = stockPriceRepository.findAll();
        List<StockPriceDTO> stockPriceDTOs = stockPrices.stream().map(StockPriceDTO::fromEntity).collect(Collectors.toList());
        if(stockPriceDTOs.isEmpty()){
            throw new EntityNotFoundException("StockPrice not found");
        }
        return stockPriceDTOs;
    }

    public List<StockPriceDTO> saveStockPrices(List<StockPriceDTO> stockPriceDTOList) {
        List<StockPrice> stockPriceList = stockPriceDTOList.stream().map(StockPriceDTO::toEntity).collect(Collectors.toList());
        List<StockPrice> savedStockPriceList = stockPriceRepository.saveAll(stockPriceList);
        List<StockPriceDTO> savedStockPriceDTOList = savedStockPriceList.stream().map(StockPriceDTO::fromEntity).collect(Collectors.toList());
        return savedStockPriceDTOList;
    }

    public StockPriceDTO updateStockPrice(Long id, StockPriceDTO stockPriceDTO) {
        stockPriceDTO.setId(id);
        StockPrice stockPrice = StockPriceDTO.toEntity(stockPriceDTO);
        StockPrice savedStockPrice = stockPriceRepository.save(stockPrice);
        return StockPriceDTO.fromEntity(savedStockPrice);
    }

    public void deleteStockPrice(StockPriceDTO stockPriceDTO) {
        StockPrice stockPrice = StockPriceDTO.toEntity(stockPriceDTO);
        stockPriceRepository.delete(stockPrice);
    }
}
