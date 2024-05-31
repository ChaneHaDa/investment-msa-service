package com.chan.investment.portfolioservice.controller;

import com.chan.investment.portfolioservice.Wrapper.PortfolioDTOWrapper;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioDTO;
import com.chan.investment.portfolioservice.jpa.service.PortfolioUserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user/portfolio")
public class PortfolioUserController {

    private final PortfolioUserService portfolioUserService;

    public PortfolioUserController(PortfolioUserService portfolioUserService) {
        this.portfolioUserService = portfolioUserService;
    }

    @GetMapping("")
    public List<PortfolioDTO> getPortfolios(Principal principal) {
        return portfolioUserService.getPortfolios(principal.getName());
    }

    @PostMapping("")
    public List<PortfolioDTO> savePortfolios(@Valid @RequestBody PortfolioDTOWrapper portfolioDTOWrapper, Principal principal) {
        return portfolioUserService.savePortfolios(portfolioDTOWrapper.getPortfolioDTOList(), principal.getName());
    }

    @PutMapping("/{id}")
    public PortfolioDTO updatePortfolio(@PathVariable(value = "id") Long id, @Valid @RequestBody PortfolioDTO portfolioDTO, Principal principal) {
        return portfolioUserService.updatePortfolio(id, portfolioDTO, principal.getName());
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable(value = "id") Long id, Principal principal) {
        portfolioUserService.deletePortfolio(id, principal.getName());
    }
}
