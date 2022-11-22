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
    //Update balance by ID
    @PutMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> updateBalance(@PathVariable String accountId, @Valid @PathVariable String balanceId, @Valid @RequestBody BalanceDto balanceDto) {
        BalanceDto balanceDtoResponse = balanceService.updateBalance (accountId,balanceId,balanceDto);
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }

}
