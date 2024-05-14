package com.chan.investment.portfoliocompositionservice.proxy;

import com.chan.investment.portfoliocompositionservice.dto.StockPriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="securities-service")
public interface SecuritiesRestProxy {
    @GetMapping("/stockprice/{number}")
    public List<StockPriceDTO> getStockPrices(@PathVariable(value = "number") String number);
}
