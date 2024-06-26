package com.chan.investment.portfolioservice.jpa.service;

import com.chan.investment.portfolioservice.exception.EntityNotFoundException;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioDTO;
import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import com.chan.investment.portfolioservice.jpa.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioDTO getPortfolioById(Long id) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        if (portfolio.isEmpty()) {
            throw new EntityNotFoundException("Portfolio with id: " + id + " not found");
        }
        return PortfolioDTO.fromEntity(portfolio.get());
    }

    public List<PortfolioDTO> getPortfolios() {
        List<Portfolio> portfolios = portfolioRepository.findAll();
        if (portfolios.isEmpty()) {
            throw new EntityNotFoundException("Portfolios not found");
        }
        List<PortfolioDTO> portfolioDTOs = portfolios.stream().map(PortfolioDTO::fromEntity).collect(Collectors.toList());
        return portfolioDTOs;
    }

    public List<PortfolioDTO> savePortfolios(List<PortfolioDTO> portfolioDTOList, String username) {
        List<Portfolio> portfolioList = portfolioDTOList.stream().map(portfolioDTO -> PortfolioDTO.toEntity(portfolioDTO, username)).collect(Collectors.toList());
        List<Portfolio> savedPortfolioList = portfolioRepository.saveAll(portfolioList);
        List<PortfolioDTO> savedPortfolioDTOList = savedPortfolioList.stream().map(PortfolioDTO::fromEntity).collect(Collectors.toList());
        return savedPortfolioDTOList;
    }

    public PortfolioDTO updatePortfolio(Long id, PortfolioDTO portfolioDTO, String username) {
        this.getPortfolioById(id);
        portfolioDTO.setId(id);
        Portfolio portfolio = PortfolioDTO.toEntity(portfolioDTO, username);
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        return PortfolioDTO.fromEntity(savedPortfolio);
    }

    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

}
