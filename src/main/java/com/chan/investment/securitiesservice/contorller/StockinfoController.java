package com.chan.investment.securitiesservice.contorller;

import com.chan.investment.securitiesservice.jpa.dto.StockinfoDTO;
import com.chan.investment.securitiesservice.jpa.service.StockinfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockinfo")
public class StockinfoController {

    private final StockinfoService stockinfoService;

    public StockinfoController(StockinfoService stockinfoService) {
        this.stockinfoService = stockinfoService;
    }

    @GetMapping("")
    public List<StockinfoDTO> getStockinfos() {
        return stockinfoService.getStockinfos();
    }

    @PostMapping("")
    public List<StockinfoDTO> saveStockinfo(@RequestBody List<StockinfoDTO> stockinfoDTOList) {
        return stockinfoService.saveStockinfos(stockinfoDTOList);
    }

    @GetMapping("/{name}")
    public StockinfoDTO getStockinfoByName(@PathVariable(value = "name") String name) {
        return stockinfoService.getStockinfoByName(name);
    }

    @PutMapping("/{id}")
    public StockinfoDTO updateStockinfo(@PathVariable(value = "id") Long id, @RequestBody StockinfoDTO stockinfoDTO) {
        return stockinfoService.updateStockinfo(id ,stockinfoDTO);
    }

    @DeleteMapping("")
    public void deleteStockinfo(@RequestBody StockinfoDTO stockinfoDTO) {
        stockinfoService.deleteStockinfo(stockinfoDTO);
    }

}
