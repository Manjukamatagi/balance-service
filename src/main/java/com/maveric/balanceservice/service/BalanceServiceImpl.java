package com.maveric.balanceservice.service;

import com.maveric.balanceservice.model.Balance;
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


//    public BalanceDto updateUser(String accountId, BalanceDto balanceDto) {
//        Balance bal = modelMapper.map(balanceDto,Balance.class);
//        return modelMapper.map(repository.save(bal),BalanceDto.class);
//    }

    @Override
    public BalanceDto updateBalance(String accountId, String balanceId, BalanceDto balanceDto) {
        Balance bal = modelMapper.map(balanceDto,Balance.class);
         return modelMapper.map(repository.save(bal),BalanceDto.class);
    }
}
