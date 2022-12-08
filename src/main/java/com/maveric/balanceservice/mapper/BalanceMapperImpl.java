package com.maveric.balanceservice.mapper;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import org.springframework.stereotype.Component;

@Component

public class BalanceMapperImpl implements BalanceMapper{

    @Override
    public BalanceDto map(Balance balance) {
        return new BalanceDto(
                balance.get_id(),
                balance.getAccountId(),
                balance.getAmount(),
                balance.getCurrency(),
                balance.getCreatedAt(),
                balance.getUpdatedAt()
        );
    }
    @Override
    public Balance map(BalanceDto balanceDto) {
        return new Balance(
                balanceDto.get_id(),
                balanceDto.getAccountId(),
                balanceDto.getAmount(),
                balanceDto.getCurrency(),
                balanceDto.getCreatedAt(),
                balanceDto.getUpdatedAt()
        );
    }

}
