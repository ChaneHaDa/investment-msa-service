package com.chan.investment.portfolioservice.controller;

import com.chan.investment.portfolioservice.Wrapper.PortfolioDTOWrapper;
import com.chan.investment.portfolioservice.Wrapper.PortfolioItemDTOWrapper;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioDTO;
import com.chan.investment.portfolioservice.jpa.dto.PortfolioItemDTO;
import com.chan.investment.portfolioservice.jpa.service.PortfolioItemService;
import com.chan.investment.portfolioservice.jpa.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final PortfolioItemService portfolioItemService;

    public PortfolioController(PortfolioService portfolioService, PortfolioItemService portfolioItemService) {
        this.portfolioService = portfolioService;
        this.portfolioItemService = portfolioItemService;
    }

    @GetMapping("")
    public List<PortfolioDTO> getPortfolios() {
        return portfolioService.getPortfolios();
    }

    @GetMapping("/{id}")
    public PortfolioDTO getPortfolioById(@PathVariable(value = "id") Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @PostMapping("")
        public List<PortfolioDTO> savePortfolios(@Valid @RequestBody PortfolioDTOWrapper portfolioDTOWrapper, String username) {
        return portfolioService.savePortfolios(portfolioDTOWrapper.getPortfolioDTOList(), username);
    }

    @PutMapping("/{id}")
    public PortfolioDTO updatePortfolio(@PathVariable(value = "id") Long id, @Valid @RequestBody PortfolioDTO portfolioDTO, String username) {

        return portfolioService.updatePortfolio(id, portfolioDTO, username);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable(value = "id") Long id) {
        portfolioService.deletePortfolio(id);
    }

    @GetMapping("/{id}/portfolioItem")
    public List<PortfolioItemDTO> getPortfolioItems(@PathVariable(value = "id") Long id) {
        return portfolioItemService.getPortfolioItemsByPortfolio(id);
    }

    @PostMapping("/{id}/portfolioItem")
    public List<PortfolioItemDTO> savePortfolioItems(@PathVariable(value = "id") Long id, @Valid @RequestBody PortfolioItemDTOWrapper portfolioItemDTOLWrapper) {
        return portfolioItemService.savePortfolioItems(id, portfolioItemDTOLWrapper.getPortfolioItemDTOList());
    }

}
