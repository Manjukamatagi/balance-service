package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

public interface BalanceService {
    public String deleteBalance(String balanceId);
    public String deleteBalanceByAccountId(String accountId);
}

