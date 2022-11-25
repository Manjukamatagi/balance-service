package com.maveric.balanceservice;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.BalanceAlreadyExistException;
import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import com.maveric.balanceservice.service.BalanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.maveric.balanceservice.BalanceServiceApplicationTests.getBalance;
import static com.maveric.balanceservice.BalanceServiceApplicationTests.getBalanceDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class BalanceServiceImplTest {
    @InjectMocks
    private BalanceServiceImpl service;

    @Mock
    private BalanceRepository repository;

    @Mock
    private BalanceMapper mapper;

    @Mock
    private Page pageResult;


    @Test
    void createBalance() {
        when(mapper.map(any(BalanceDto.class))).thenReturn(getBalance());
        when(mapper.map(any(Balance.class))).thenReturn(getBalanceDto());
        when(repository.save(any())).thenReturn(getBalance());
        BalanceDto balanceDto = service.createBalance(getBalance().getAccountId(),getBalanceDto());
        assertSame(balanceDto.getAccountId(), getBalance().getAccountId());
    }
    @Test
    void createBalance_failure() {
        when(repository.findByAccountId("123")).thenReturn(getBalance());
        Throwable error = assertThrows(BalanceAlreadyExistException.class,()->service.createBalance("123",getBalanceDto()));
        assertEquals("Balance already exists for this Account Id-123",error.getMessage());
    }

    @Test
    void createBalance_failure2() {
        Throwable error = assertThrows(BalanceNotFoundException.class,()->service.createBalance("12",getBalanceDto()));
        assertEquals("Account Id not found! Cannot create balance.",error.getMessage());
    }

}