package com.chan.investment.securitiesservice.jpa.service;

import com.chan.investment.securitiesservice.jpa.dto.StockinfoDTO;
import com.chan.investment.securitiesservice.jpa.entity.Stockinfo;
import com.chan.investment.securitiesservice.jpa.repository.StockinfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockinfoService {

    private final StockinfoRepository stockinfoRepository;

    public StockinfoService(StockinfoRepository stockinfoRepository) {
        this.stockinfoRepository = stockinfoRepository;
    }

    public List<StockinfoDTO> saveAll(List<StockinfoDTO> stockinfoDTOList) {
        List<Stockinfo> stockinfoList = stockinfoDTOList.stream().map(StockinfoDTO::toEntity).collect(Collectors.toList());
        List<Stockinfo> savedStockinfoList = stockinfoRepository.saveAll(stockinfoList);
        List<StockinfoDTO> savedStockinfoDTOList = savedStockinfoList.stream().map(StockinfoDTO::fromEntity).collect(Collectors.toList());
        return savedStockinfoDTOList;
    }

    public List<StockinfoDTO> findAll() {
        List<Stockinfo> stockinfos = stockinfoRepository.findAll();
        List<StockinfoDTO> stockinfoDTOs = stockinfos.stream().map(StockinfoDTO::fromEntity).collect(Collectors.toList());
        return stockinfoDTOs;
    }

    public StockinfoDTO findByname(String name) {
        Stockinfo stockinfo = stockinfoRepository.findByName(name);
        return StockinfoDTO.fromEntity(stockinfo);
    }

    public StockinfoDTO update(Long id, StockinfoDTO stockinfoDTO) {
        stockinfoDTO.setId(id);
        Stockinfo stockinfo = StockinfoDTO.toEntity(stockinfoDTO);
        Stockinfo savedStockinfo = stockinfoRepository.save(stockinfo);
        return StockinfoDTO.fromEntity(savedStockinfo);
    }

    public void delete(StockinfoDTO stockinfoDTO) {
    }
}
