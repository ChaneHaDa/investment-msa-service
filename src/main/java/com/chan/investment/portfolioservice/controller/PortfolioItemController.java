package com.chan.investment.portfolioservice.controller;

import com.chan.investment.portfolioservice.jpa.dto.PortfolioItemDTO;
import com.chan.investment.portfolioservice.jpa.service.PortfolioItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolioItem")
public class PortfolioItemController {

    private final PortfolioItemService portfolioItemService;

    public PortfolioItemController(PortfolioItemService portfolioItemService) {
        this.portfolioItemService = portfolioItemService;
    }

    @GetMapping("")
    public List<PortfolioItemDTO> getPortfolioItems() {
        return portfolioItemService.getPortfolioItems();
    }

    @GetMapping("/{id}")
    public PortfolioItemDTO getPortfolioItemById(@PathVariable(value = "id") Long id) {
        return portfolioItemService.getPortfolioItemById(id);
    }

    @PutMapping("/{id}")
    public PortfolioItemDTO updatePortfolioItem(@PathVariable(value = "id") Long id, @Valid @RequestBody PortfolioItemDTO portfolioItemDTO) {
        return portfolioItemService.updatePortfolioItem(id, portfolioItemDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolioItem(@PathVariable(value = "id") Long id) {
        portfolioItemService.deletePortfolioItem(id);
    }

}
