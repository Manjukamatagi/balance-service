package com.maveric.balanceservice.mapper;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.maveric.balanceservice.BalanceServiceApplicationTests.getBalance;
import static com.maveric.balanceservice.BalanceServiceApplicationTests.getBalanceDto;
import static org.junit.Assert.assertEquals;

class BalanceMapperImplTest {
    BalanceMapperImpl balanceMapper=new BalanceMapperImpl();
    @Test
    void map() {
        BalanceDto balanceDto=getBalanceDto();
        Balance balance = balanceMapper.map(balanceDto);
        assertEquals(getBalanceDto().getAccountId(), balance.getAccountId());
        assertEquals(getBalanceDto().get_id(), balance.get_id());
    }

    @Test
    void testMap() {
        Balance balance=getBalance();
        BalanceDto balancedto = balanceMapper.map(balance);
        assertEquals(getBalance().getAccountId(), balancedto.getAccountId());
        assertEquals(getBalance().get_id(), balancedto.get_id());
    }

}