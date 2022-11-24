package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.service.BalanceService;
import org.slf4j.Logger;
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
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BalanceController.class);

    //Returns the User Balance details By balance ID

    @GetMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<String> getBalanceDetails(@PathVariable String accountId,@PathVariable String balanceId) {
        log.info("API call returning balance for the given valid Account Id");
        BalanceDto balanceDtoResponse = balanceService.getBalanceDetails(accountId,balanceId);
        return new ResponseEntity<>(String.valueOf(balanceDtoResponse.getAmount()), HttpStatus.OK);
    }

}


