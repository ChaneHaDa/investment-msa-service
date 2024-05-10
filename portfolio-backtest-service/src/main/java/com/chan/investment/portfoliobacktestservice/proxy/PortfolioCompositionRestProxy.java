package com.chan.investment.portfoliobacktestservice.proxy;

import com.chan.investment.portfoliobacktestservice.dto.PortfolioCompositionReturnDTO;
import com.chan.investment.portfoliobacktestservice.dto.PortfolioCompositionInputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="portfolio-composition-service", url="localhost:8040/portfolio-composition")
public interface PortfolioCompositionRestProxy {
    @PostMapping("")
    public PortfolioCompositionReturnDTO createPortfolio(@RequestBody PortfolioCompositionInputDTO portofolioCompostionInputDTO);
}
