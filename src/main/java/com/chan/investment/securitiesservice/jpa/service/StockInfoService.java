package com.chan.investment.securitiesservice.jpa.service;

import com.chan.investment.securitiesservice.exception.EntityNotFoundException;
import com.chan.investment.securitiesservice.jpa.dto.StockInfoDTO;
import com.chan.investment.securitiesservice.jpa.entity.StockInfo;
import com.chan.investment.securitiesservice.jpa.repository.StockInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockInfoService {

    private final StockInfoRepository stockinfoRepository;

    public StockInfoService(StockInfoRepository stockinfoRepository) {
        this.stockinfoRepository = stockinfoRepository;
    }

    public StockInfoDTO getStockInfoById(Long id) {
        Optional<StockInfo> stockinfo = stockinfoRepository.findById(id);
        if(stockinfo.isEmpty()){
            throw new EntityNotFoundException("Id: " + id + " not found");
        }
        return StockInfoDTO.fromEntity(stockinfo.get());
    }

    public StockInfoDTO getStockInfoByName(String name) {
        StockInfo stockinfo = stockinfoRepository.findByName(name);
        if(stockinfo == null){
            throw new EntityNotFoundException("Name: " + name + " not found");
        }
        return StockInfoDTO.fromEntity(stockinfo);
    }

    public List<StockInfoDTO> getStockInfos() {
        List<StockInfo> stockinfos = stockinfoRepository.findAll();
        List<StockInfoDTO> stockinfoDTOs = stockinfos.stream().map(StockInfoDTO::fromEntity).collect(Collectors.toList());
        if(stockinfoDTOs.isEmpty()){
            throw new EntityNotFoundException("Stockinfo not found");
        }
        return stockinfoDTOs;
    }
    

    public List<StockInfoDTO> saveStockInfos(List<StockInfoDTO> stockinfoDTOList) {
        List<StockInfo> stockinfoList = stockinfoDTOList.stream().map(StockInfoDTO::toEntity).collect(Collectors.toList());
        List<StockInfo> savedStockinfoList = stockinfoRepository.saveAll(stockinfoList);
        List<StockInfoDTO> savedStockinfoDTOList = savedStockinfoList.stream().map(StockInfoDTO::fromEntity).collect(Collectors.toList());
        return savedStockinfoDTOList;
    }

    public StockInfoDTO updateStockInfo(Long id, StockInfoDTO stockinfoDTO) {
        this.getStockInfoById(id);
        stockinfoDTO.setId(id);
        StockInfo stockinfo = StockInfoDTO.toEntity(stockinfoDTO);
        StockInfo savedStockinfo = stockinfoRepository.save(stockinfo);
        return StockInfoDTO.fromEntity(savedStockinfo);
    }

    public void deleteStockinfo(Long id) {
        stockinfoRepository.deleteById(id);
    }
}
