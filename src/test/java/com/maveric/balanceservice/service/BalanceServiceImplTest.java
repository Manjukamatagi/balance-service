package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

import com.maveric.balanceservice.exception.BalanceAlreadyExistException;


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

    void deleteBalance() {
        when(repository.findById("2")).thenReturn(Optional.of(getBalance()));
        willDoNothing().given(repository).deleteById("2");
        String balanceDto = service.deleteBalance("2");
        assertSame("Balance deleted successfully.", balanceDto);
    }

    @Test
    void deleteBalance_failure() {
        when(repository.findById("3")).thenReturn(Optional.empty());
        Throwable error = assertThrows(BalanceNotFoundException.class, () -> service.deleteBalance("3"));
        assertEquals("Balance not Found for Id-3", error.getMessage());
    }

    @Test
    void deleteBalanceByAccountId() {
        willDoNothing().given(repository).deleteByAccountId("123");
        String balanceDto = service.deleteBalanceByAccountId("123");
        assertSame("Balance deleted successfully.", balanceDto);
    }
        @Test
    void updateBalance() {
        when(repository.findById("2")).thenReturn(Optional.ofNullable(getBalance()));
        when(mapper.map(any(Balance.class))).thenReturn(getBalanceDto());
        when(repository.save(any())).thenReturn(getBalance());
        BalanceDto BalanceDto = service.updateBalance("8123", "2", getBalanceDto());
        assertSame(BalanceDto.getAccountId(), getBalanceDto().getAccountId());
    }

    @Test
    void updateBalance_failure() {
        Throwable error = assertThrows(BalanceNotFoundException.class, () -> service.updateBalance("1", "123", getBalanceDto()));//NOSONAR
        assertEquals("Account Id not found! Cannot Update Balance", error.getMessage());
    }

    @Test
    void createBalance() {
        when(mapper.map(any(BalanceDto.class))).thenReturn(getBalance());
        when(mapper.map(any(Balance.class))).thenReturn(getBalanceDto());
        when(repository.save(any())).thenReturn(getBalance());
        BalanceDto balanceDto = service.createBalance(getBalance().getAccountId(),getBalanceDto());
        assertSame(balanceDto.getAccountId(), getBalance().getAccountId());

    }
}