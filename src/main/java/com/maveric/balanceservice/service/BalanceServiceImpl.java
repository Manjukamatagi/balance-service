package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dao.Balance;
import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.BalanceAlreadyExistException;
import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.maveric.balanceservice.constants.Constants.getCurrentDateTime;

@Service
public class BalanceServiceImpl implements  BalanceService{

    @Autowired
    private BalanceRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BalanceMapper mapper;

//    @Override
//    public BalanceDto createBalance(String accountId, BalanceDto balanceDto) {
//        Balance bal = modelMapper.map(balanceDto,Balance.class);
//        return modelMapper.map(repository.save(bal),BalanceDto.class);
//    }

    public BalanceDto createBalance(String accountId, BalanceDto balanceDto) {
        if (accountId.equals(balanceDto.getAccountId())) {
            if(repository.findByAccountId(accountId)==null) {
                balanceDto.setCreatedAt(getCurrentDateTime());
                balanceDto.setUpdatedAt(getCurrentDateTime());
                Balance balance = mapper.map(balanceDto);
                Balance balanceResult = repository.save(balance);
//                log.error("Created new Balance successfully");
                return mapper.map(balanceResult);
            }
            else {
//                log.error("Balance Already Exist for this Account Id");
                throw new BalanceAlreadyExistException("Balance already exists for this Account Id-"+balanceDto.getAccountId());
            }
        }
//        else {
////            log.error("Account Id not found! Cannot create balance.");
//            throw new BalanceNotFoundException("Account Id not found! Cannot create balance.");
//        }
        Balance bal = modelMapper.map(balanceDto,Balance.class);
        return modelMapper.map(repository.save(bal),BalanceDto.class);
    }
}
