package com.chan.investment.portfolioservice.jpa.service;

import com.chan.investment.portfolioservice.exception.EntityNotFoundException;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioDTO;
import com.chan.investment.portfolioservice.jpa.entity.Portfolio;
import com.chan.investment.portfolioservice.jpa.repository.PortfolioRepository;
import jakarta.ws.rs.ForbiddenException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioUserService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioUserService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<PortfolioDTO> getPortfolios(String username) {
        List<Portfolio> portfolios = portfolioRepository.findAllByUsername(username);
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
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Portfolio with id: " + id + " not found"));
        if(!portfolio.getUsername().equals(username)){
            throw new ForbiddenException("You are not allowed to update this portfolio");
        }
        portfolioDTO.setId(id);
        Portfolio updatePortfolio = PortfolioDTO.toEntity(portfolioDTO, username);
        Portfolio savedPortfolio = portfolioRepository.save(updatePortfolio);
        return PortfolioDTO.fromEntity(savedPortfolio);
    }

    public void deletePortfolio(Long id, String username){
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Portfolio with id: " + id + " not found"));
        if(!portfolio.getUsername().equals(username)){
            throw new ForbiddenException("You are not allowed to update this portfolio");
        }
        portfolioRepository.deleteById(id);
    }

}
