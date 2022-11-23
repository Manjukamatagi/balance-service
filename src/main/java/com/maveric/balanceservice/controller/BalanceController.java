package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")


public class BalanceController {

    @Autowired
    BalanceService balanceService;

    //Returns the User Balance details By account ID
    @GetMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> getBalances(@PathVariable String accountId) {
        BalanceDto balanceDtoResponse = balanceService.getBalanceByAccountId(accountId);
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }

}


