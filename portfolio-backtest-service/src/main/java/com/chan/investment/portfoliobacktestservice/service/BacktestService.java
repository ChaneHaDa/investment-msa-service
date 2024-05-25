package com.chan.investment.portfoliobacktestservice.service;

import com.chan.investment.portfoliobacktestservice.Wrapper.BacktestItemDTOWrapper;
import com.chan.investment.portfoliobacktestservice.dto.BacktestItemDTO;
import com.chan.investment.portfoliobacktestservice.dto.BacktestResultDTO;
import com.chan.investment.portfoliobacktestservice.utils.CalculatorUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BacktestService {

    public BacktestResultDTO getBacktestResult(BacktestItemDTOWrapper backtestItemDTOWrapper) {
        List<BacktestItemDTO> backtestItemDTOList = backtestItemDTOWrapper.getBacktestItemDTOList();
        List<List<Double>> itemRorList = new ArrayList<>();
        List<Double> weightList = new ArrayList<>();
        List<Double> rorList = new ArrayList<>();

        for (BacktestItemDTO backtestItemDTO : backtestItemDTOList) {
            List<Double> priceList = backtestItemDTO.getPriceList();
            double weight = backtestItemDTO.getWeight();
            List<Double> rorListByItem = CalculatorUtils.getRorByList(priceList);
            itemRorList.add(rorListByItem);
            weightList.add(weight);
        }

        for (int i = 0; i < itemRorList.get(0).size(); i++) {
            double ror = 0;
            for (int j = 0; j < itemRorList.size(); j++) {
                ror += itemRorList.get(j).get(i) * weightList.get(j);
            }
            rorList.add(ror);
        }

        double totalRor = CalculatorUtils.getTotalRor(rorList);
        double amount = CalculatorUtils.getAmountByRor(backtestItemDTOWrapper.getAmount(), totalRor);
        double maxRor = rorList.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double minRor = rorList.stream().mapToDouble(Double::doubleValue).min().orElse(0);

        return new BacktestResultDTO(itemRorList, rorList, totalRor, maxRor, minRor, amount);
    }

}

