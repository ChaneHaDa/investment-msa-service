package com.chan.investment.securitiesservice.contorller;

import com.chan.investment.securitiesservice.jpa.dto.StockPriceDTO;
import com.chan.investment.securitiesservice.jpa.service.StockPriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
    private final StockPriceService stockPriceService;

    public StockPriceController(StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @GetMapping("")
    public List<StockPriceDTO> getStockPrices() {
        return stockPriceService.getStockPrices();
    }

    @GetMapping("/{number}")
    public List<StockPriceDTO> getStockPrices(@PathVariable(value = "number") String number) {
        return stockPriceService.getStockPricesByNumber(number);
    }

    @PostMapping("")
    public List<StockPriceDTO> saveStockPrices(@RequestBody List<StockPriceDTO> stockPriceDTOList) {
        return stockPriceService.saveStockPrices(stockPriceDTOList);
    }

    @PutMapping("/{id}")
    public StockPriceDTO updateStockPrice(@PathVariable(value = "id") Long id, @RequestBody StockPriceDTO stockPriceDTO) {
        return stockPriceService.updateStockPrice(id, stockPriceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStockPrice(@PathVariable(value = "id") Long id) {
        stockPriceService.deleteStockPrice(id);
    }
}
