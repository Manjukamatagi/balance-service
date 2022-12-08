package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;

public interface BalanceService {
    public BalanceDto updateBalance(String accountId,String balanceId,BalanceDto balanceDto);
    public BalanceDto createBalance(String accountId, BalanceDto balanceDto);
}
