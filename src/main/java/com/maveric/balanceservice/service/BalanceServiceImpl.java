package com.maveric.balanceservice.service;

import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.maveric.balanceservice.constants.Constants.BALANCE_DELETED_SUCCESS;
import static com.maveric.balanceservice.constants.Constants.BALANCE_NOT_FOUND_MESSAGE;

@Service
public class BalanceServiceImpl implements  BalanceService{

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BalanceServiceImpl.class);

    @Autowired
    private BalanceRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BalanceMapper mapper;

    @Override
    public String deleteBalance(String balanceId) {
        if(repository.findById(balanceId).isEmpty())
        {
            log.info("Balance Id does not exist! Cannot delete Balance details.");
            throw new BalanceNotFoundException(BALANCE_NOT_FOUND_MESSAGE+balanceId);
        }
        repository.deleteById(balanceId);
        log.info("Deleted Balance details for given Balance Id");
        return BALANCE_DELETED_SUCCESS;
    }
    @Override
    public String deleteBalanceByAccountId(String accountId) {
        repository.deleteByAccountId(accountId);
        return BALANCE_DELETED_SUCCESS;
    }


}
