package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

public interface BalanceService {

    public BalanceDto getBalanceDetails(String accountId,String balanceId);

}

