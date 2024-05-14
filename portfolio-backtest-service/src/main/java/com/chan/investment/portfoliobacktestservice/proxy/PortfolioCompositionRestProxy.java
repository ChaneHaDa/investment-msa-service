package com.chan.investment.portfoliobacktestservice.proxy;

import com.chan.investment.portfoliobacktestservice.dto.PortfolioCompositionReturnDTO;
import com.chan.investment.portfoliobacktestservice.dto.PortfolioCompositionInputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="portfolio-composition-service")
public interface PortfolioCompositionRestProxy {
    @PostMapping("/portfolio-composition")
    public PortfolioCompositionReturnDTO createPortfolio(@RequestBody PortfolioCompositionInputDTO portofolioCompostionInputDTO);
}
