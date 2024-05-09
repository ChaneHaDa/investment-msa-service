package com.chan.investment.backtestservice.wrapper;

import com.chan.investment.backtestservice.dto.BacktestItemDTO;

import java.util.List;

public class BacktestItemDTOWrapper {
    private List<BacktestItemDTO> backtestItemDTOList;

    private long amount;

    public BacktestItemDTOWrapper() {
    }

    public BacktestItemDTOWrapper(List<BacktestItemDTO> backtestItemDTOList, long amount) {
        this.backtestItemDTOList = backtestItemDTOList;
        this.amount = amount;
    }

    public List<BacktestItemDTO> getBacktestItemDTOList() {
        return backtestItemDTOList;
    }

    public void setBacktestItemDTOList(List<BacktestItemDTO> backtestItemDTOList) {
        this.backtestItemDTOList = backtestItemDTOList;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
