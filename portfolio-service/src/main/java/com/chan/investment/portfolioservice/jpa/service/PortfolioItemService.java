package com.chan.investment.portfolioservice.jpa.service;

import com.chan.investment.portfolioservice.exception.EntityNotFoundException;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioItemDTO;
import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import com.chan.investment.portfolioservice.jpa.entity.PortfolioItem;
import com.chan.investment.portfolioservice.jpa.repository.PortfolioItemRepository;
import com.chan.investment.portfolioservice.jpa.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PortfolioItemService {

    private final PortfolioItemRepository portfolioItemRepository;
    private final PortfolioRepository portfolioRepository;

    public PortfolioItemService(PortfolioItemRepository portfolioItemRepository, PortfolioRepository portfolioRepository) {
        this.portfolioItemRepository = portfolioItemRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioItemDTO getPortfolioItemById(Long id) {
        Optional<PortfolioItem> portfolioItem = portfolioItemRepository.findById(id);
        if (portfolioItem == null) {
            throw new EntityNotFoundException("PortfolioItem with id: " + id + " not found");
        }
        return PortfolioItemDTO.fromEntity(portfolioItem.get());
    }

    public List<PortfolioItemDTO> getPortfolioItemsByPortfolio(Long id) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        if (portfolio.isEmpty()) {
            throw new EntityNotFoundException("Portfolio with id: " + id + " not found");
        }
        List<PortfolioItem> portfolioItems = portfolioItemRepository.findByPortfolio(portfolio.get());
        if (portfolioItems.isEmpty()) {
            throw new RuntimeException("PortfolioItems not found");
        }
        List<PortfolioItemDTO> portfolioItemDTOs = portfolioItems.stream().map(PortfolioItemDTO::fromEntity).collect(Collectors.toList());
        return portfolioItemDTOs;
    }

    public List<PortfolioItemDTO> getPortfolioItems() {
        List<PortfolioItem> portfolioItems = portfolioItemRepository.findAll();
        if (portfolioItems.isEmpty()) {
            throw new EntityNotFoundException("PortfolioItems not found");
        }
        List<PortfolioItemDTO> portfolioItemDTOs = portfolioItems.stream().map(PortfolioItemDTO::fromEntity).collect(Collectors.toList());
        return portfolioItemDTOs;
    }

    public List<PortfolioItemDTO> savePortfolioItems(Long portfolioId, List<PortfolioItemDTO> portfolioItemDTOList) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
        if (portfolio.isEmpty()) {
            throw new EntityNotFoundException("Portfolio with id: " + portfolioId + " not found");
        }
        Portfolio portfolioEntity = portfolio.get();
        List<PortfolioItem> portfolioItemList = portfolioItemDTOList.stream().map(t -> new PortfolioItem(t.getId(), t.getStock(), t.getWeight(), portfolioEntity)).collect(Collectors.toList());
        List<PortfolioItem> savedPortfolioItemList = portfolioItemRepository.saveAll(portfolioItemList);
        List<PortfolioItemDTO> savedPortfolioItemDTOList = savedPortfolioItemList.stream().map(PortfolioItemDTO::fromEntity).collect(Collectors.toList());
        return savedPortfolioItemDTOList;
    }

    public PortfolioItemDTO updatePortfolioItem(Long id, PortfolioItemDTO portfolioItemDTO) {
        this.getPortfolioItemById(id);
        portfolioItemDTO.setId(id);
        PortfolioItem portfolioItem = PortfolioItemDTO.toEntity(portfolioItemDTO);
        PortfolioItem savedPortfolioItem = portfolioItemRepository.save(portfolioItem);
        return PortfolioItemDTO.fromEntity(savedPortfolioItem);
    }

    public void deletePortfolioItem(Long id) {
        portfolioItemRepository.deleteById(id);
    }

}
