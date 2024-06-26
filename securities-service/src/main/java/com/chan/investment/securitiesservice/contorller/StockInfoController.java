package com.chan.investment.securitiesservice.contorller;

import com.chan.investment.securitiesservice.jpa.dto.StockInfoDTO;
import com.chan.investment.securitiesservice.jpa.service.StockInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockinfo")
public class StockInfoController {

    private final StockInfoService stockinfoService;

    public StockInfoController(StockInfoService stockinfoService) {
        this.stockinfoService = stockinfoService;
    }

    @GetMapping("")
    public List<StockInfoDTO> getStockinfos() {
        return stockinfoService.getStockInfos();
    }

    @PostMapping("")
    public List<StockInfoDTO> saveStockinfo(@RequestBody List<StockInfoDTO> stockinfoDTOList) {
        return stockinfoService.saveStockInfos(stockinfoDTOList);
    }

    @GetMapping("/{name}")
    public StockInfoDTO getStockinfoByName(@PathVariable(value = "name") String name) {
        return stockinfoService.getStockInfoByName(name);
    }

    @PutMapping("/{id}")
    public StockInfoDTO updateStockinfo(@PathVariable(value = "id") Long id, @RequestBody StockInfoDTO stockinfoDTO) {
        return stockinfoService.updateStockInfo(id ,stockinfoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStockinfo(@PathVariable(value = "id") Long id) {
        stockinfoService.deleteStockinfo(id);
    }

}
