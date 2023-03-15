package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.AccountIdMismatchException;
import com.maveric.balanceservice.exception.BalanceIdNotFoundException;
import com.maveric.balanceservice.model.Balance;

public interface BalanceService {

    BalanceDto getBalanceByAccountId(String accountId);
    BalanceDto getBalanceIdByAccountId(String accountId, String balanceId) throws BalanceIdNotFoundException, AccountIdMismatchException;

    public BalanceDto createBalance(String accountId, BalanceDto balanceDto);
    public BalanceDto getBalanceDetails(String accountId,String balanceId);
    public String deleteBalance(String balanceId);
    public String deleteBalanceByAccountId(String accountId);
    public BalanceDto updateBalance(String accountId,String balanceId,BalanceDto balanceDto);
}



