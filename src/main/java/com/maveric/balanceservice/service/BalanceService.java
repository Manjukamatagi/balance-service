package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

public interface BalanceService {
BalanceDto getBalanceByAccountId(String accountId);
    public BalanceDto getBalanceDetails(String accountId,String balanceId);

}

