package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.BalanceAlreadyExistException;
import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.maveric.balanceservice.constants.Constants.*;

@Service
public class BalanceServiceImpl implements BalanceService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BalanceServiceImpl.class);
    @Autowired
    private BalanceRepository repository;

    @Autowired
    private BalanceMapper mapper;

//    @Override
//    public BalanceDto getBalanceByAccountId(String accountId) {
//
//        Balance balanceResult = repository.     findByAccountId(accountId);
//        if (balanceResult != null)
//        {
//            log.info("Retrieved Balance details for given Account Id");
//            return mapper.map(balanceResult);
//        }
//        else
//        {
//            log.info("Balance not found for given Account Id returns Empty Balance details");
//            return new BalanceDto();
//        }
//    }


    @Override
    public BalanceDto getBalanceDetails(String accountId,String balanceId) {
        log.info("Retrieved list of Balance details for given Balance Id");
        Balance balanceResult = repository.findById(balanceId).orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
        return mapper.map(balanceResult);
    }




}
