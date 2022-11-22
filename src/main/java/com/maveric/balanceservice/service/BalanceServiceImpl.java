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
    public BalanceDto getBalanceByAccountId(String accountId) {
        Balance balanceResult = repository.findByAccountId(accountId);
        Balance bal = modelMapper.map(balanceResult,Balance.class);
        return modelMapper.map(repository.save(bal),BalanceDto.class);
    }
}
