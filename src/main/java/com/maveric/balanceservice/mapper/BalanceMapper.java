package com.maveric.balanceservice.mapper;


import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="Balance")
public interface BalanceMapper {

    BalanceDto map(Balance balance);
    Balance map(BalanceDto balanceDto);

}
