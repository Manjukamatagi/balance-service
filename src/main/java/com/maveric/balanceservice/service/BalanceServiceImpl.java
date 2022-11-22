package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dao.Balance;
import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements  BalanceService{

    @Autowired
    private BalanceRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String deleteBalance(String balanceId) {
        Balance ball = modelMapper.map(balanceId,Balance.class);
        return modelMapper.map(repository.save(ball),String.class);
    }

    @Override
    public String deleteBalanceByAccountId(String accountId) {
        Balance bal = modelMapper.map(accountId,Balance.class);
         return modelMapper.map(repository.save(bal),String.class);
    }

}
