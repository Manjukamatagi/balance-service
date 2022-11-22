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

    /* Delete Balance details by balanceId */
    @DeleteMapping("accounts/{accountId}/balances/{balancesId}")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId,@PathVariable String balancesId) {
        String result = balanceService.deleteBalance(balancesId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /* Delete Balance details by accountId */
    @DeleteMapping("accounts/{accountId}/balances")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId) {
//        log.info("API call to delete balance based on Account Id");
        String result = balanceService.deleteBalanceByAccountId(accountId);
//        log.info("Balance deleted successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}


