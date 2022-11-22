package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

public interface BalanceService {
    public BalanceDto createBalance(String accountId, BalanceDto balanceDto);
}
