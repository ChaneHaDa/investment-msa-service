package com.chan.investment.portfolioservice.jpa.service;

import com.chan.investment.portfolioservice.exception.EntityNotFoundException;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioItemDTO;
import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import com.chan.investment.portfolioservice.jpa.entity.PortfolioItem;
import com.chan.investment.portfolioservice.jpa.repository.PortfolioItemRepository;
import com.chan.investment.portfolioservice.jpa.repository.PortfolioRepository;
import jakarta.ws.rs.ForbiddenException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PortfolioItemUserService {

    private final PortfolioItemRepository portfolioItemRepository;
    private final PortfolioRepository portfolioRepository;

    public PortfolioItemUserService(PortfolioItemRepository portfolioItemRepository, PortfolioRepository portfolioRepository) {
        this.portfolioItemRepository = portfolioItemRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public List<PortfolioItemDTO> getPortfolioItemsByPortfolio(Long id, String username) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        if (portfolio.isEmpty()) {
            throw new EntityNotFoundException("Portfolio with id: " + id + " not found");
        }
        if (!portfolio.get().getUsername().equals(username)) {
            throw new ForbiddenException("You are not allowed to view this portfolio");
        }
        List<PortfolioItem> portfolioItems = portfolioItemRepository.findByPortfolio(portfolio.get());
        if (portfolioItems.isEmpty()) {
            throw new RuntimeException("PortfolioItems not found");
        }
        List<PortfolioItemDTO> portfolioItemDTOs = portfolioItems.stream().map(PortfolioItemDTO::fromEntity).collect(Collectors.toList());
        return portfolioItemDTOs;
    }

    public List<PortfolioItemDTO> savePortfolioItems(Long portfolioId, List<PortfolioItemDTO> portfolioItemDTOList, String username) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
        if (portfolio.isEmpty()) {
            throw new EntityNotFoundException("Portfolio with id: " + portfolioId + " not found");
        }
        Portfolio portfolioEntity = portfolio.get();
        if (!portfolioEntity.getUsername().equals(username)) {
            throw new ForbiddenException("You are not allowed to update this portfolio");
        }
        List<PortfolioItem> portfolioItemList = portfolioItemDTOList.stream().map(t -> new PortfolioItem(t.getId(), t.getStock(), t.getWeight(), portfolioEntity)).collect(Collectors.toList());
        List<PortfolioItem> savedPortfolioItemList = portfolioItemRepository.saveAll(portfolioItemList);
        List<PortfolioItemDTO> savedPortfolioItemDTOList = savedPortfolioItemList.stream().map(PortfolioItemDTO::fromEntity).collect(Collectors.toList());
        return savedPortfolioItemDTOList;
    }
}
