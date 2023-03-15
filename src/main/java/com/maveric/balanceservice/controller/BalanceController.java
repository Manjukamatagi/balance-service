package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.constants.MessageConstant;
import com.maveric.balanceservice.dto.AccountDto;
import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.AccountIdMismatchException;
import com.maveric.balanceservice.exception.BalanceIdNotFoundException;
import com.maveric.balanceservice.exception.CustomerIDNotFoundExistsException;
import com.maveric.balanceservice.feignAccount.AccountFeignService;
import com.maveric.balanceservice.service.BalanceService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")

public class BalanceController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BalanceController.class);
    @Autowired
    BalanceService balanceService;

    @Autowired
    AccountFeignService accountFeignService;

    /* Returns the User Balance details*/
//    @GetMapping("accounts/{accountId}/balances")
//    public ResponseEntity<BalanceDto> getBalances(@PathVariable String accountId) {
//        BalanceDto balanceDtoResponse = balanceService.getBalanceByAccountId(accountId);
//        log.info("API call returning Balance details for given Account Id");
//        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
//    }
//
        @GetMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> getAllBalanceByAccountId(@PathVariable("accountId") @Valid String accountId,
                                                               @RequestHeader(value = "userid") String headerUserId) throws BalanceIdNotFoundException, AccountNotFoundException {
//            AccountDto accountDto = accountFeignService.getAccountByUserId(accountId, headerUserId);
//            if (accountDto != null) {
                BalanceDto balanceDto = balanceService.getBalanceByAccountId(accountId);
                System.out.println("Get balance for the account id");
                return new ResponseEntity<>(balanceDto, HttpStatus.OK);
//            } else {
//                throw new CustomerIDNotFoundExistsException(MessageConstant.NOT_AUTHORIZED_USER);
//
//            }

        }



    @GetMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> getBalanceByAccountId(@PathVariable("accountId") String accountId,
                                                            @PathVariable("balanceId") String balanceId,
                                                            @RequestHeader(value = "userid") String headerUserId)
            throws BalanceIdNotFoundException, AccountIdMismatchException, AccountNotFoundException {
        AccountDto accountDto = accountFeignService.getAccountByUserId(accountId, headerUserId);
        if(accountDto != null){
            return new ResponseEntity<>(balanceService.getBalanceIdByAccountId(accountId, balanceId), HttpStatus.OK);
        }
        else{
            throw new CustomerIDNotFoundExistsException(MessageConstant.NOT_AUTHORIZED_USER);
        }
    }

//    //Returns the User Balance details By balance ID
//    @GetMapping("accounts/{accountId}/balances/{balanceId}")
//    public ResponseEntity<String> getBalanceDetails(@PathVariable String accountId,@PathVariable String balanceId) {
//        log.info("API call returning balance for the given valid Account Id");
//        BalanceDto balanceDtoResponse = balanceService.getBalanceDetails(accountId, balanceId);
//        return new ResponseEntity<>(String.valueOf(balanceDtoResponse.getAmount()), HttpStatus.OK);
//
//    }
    //Update balance by ID
    @PutMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> updateBalance(@PathVariable String accountId,@PathVariable String balanceId,@Valid @RequestBody BalanceDto balanceDto) {
        log.info("API call to Update Balance for valid Balance Id");
        BalanceDto balanceDtoResponse = balanceService.updateBalance(accountId, balanceId, balanceDto);
        log.info("Balance Updated successfully");
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }

    /* Saving the balance details by accountId */
//    @PostMapping("accounts/{accountId}/balances")
//    public ResponseEntity<BalanceDto> createBalance(@PathVariable String accountId,@Valid @RequestBody BalanceDto balanceDto) {
//        log.info("API call to create a new Balance for given Account Id");
//        BalanceDto balanceDtoResponse = balanceService.createBalance(accountId,balanceDto);
//        log.info("New Balance Created successfully");
//        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.CREATED);
//    }

    @PostMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> createBalance(@PathVariable String accountId,
                                                    @Valid @RequestBody BalanceDto balanceDto,
                                                    @RequestHeader(value = "userid") String headerUserId) throws AccountNotFoundException {

        AccountDto accountDto = accountFeignService.getAccountByUserId(accountId, headerUserId);
        if(accountDto != null) {
            System.out.println(accountId);
            log.info("API call to create a new Balance for given Account Id");
            BalanceDto balanceDtoResponse = balanceService.createBalance(accountId, balanceDto);
            log.info("New Balance Created successfully");
            return new ResponseEntity<>(balanceDtoResponse, HttpStatus.CREATED);

        }

        else {
            throw new CustomerIDNotFoundExistsException(MessageConstant.NOT_AUTHORIZED_USER);
        }
    }

    /* Delete Balance details by balanceId */
//    @DeleteMapping("accounts/{accountId}/balances/{balancesId}")
//    public ResponseEntity<String> deleteBalance(@PathVariable String accountId,@PathVariable String balancesId) {
//        String result = balanceService.deleteBalance(balancesId);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//    /* Delete Balance details by accountId */
//    @DeleteMapping("accounts/{accountId}/balances")
//    public ResponseEntity<String> deleteBalance(@PathVariable String accountId) {
//        log.info("API call to delete balance based on Account Id");
//        String result = balanceService.deleteBalanceByAccountId(accountId);
//        log.info("Balance deleted successfully");
//        return new ResponseEntity<>(result, HttpStatus.OK);
//
//    }


    @DeleteMapping("/accounts/{accountId}/balances")
    public ResponseEntity<String> deleteBalanceByAccountId(@PathVariable("accountId") String accountId,
                                                           @RequestHeader(value = "userid") String headerUserId) throws AccountNotFoundException {
        AccountDto accountDto = accountFeignService.getAccountByUserId(accountId, headerUserId);
        if(accountDto != null) {
            balanceService.deleteBalanceByAccountId(accountId);
            return new ResponseEntity<>("Transactions deleted successfully", HttpStatus.OK);
        }
        else {
            throw new CustomerIDNotFoundExistsException(MessageConstant.NOT_AUTHORIZED_USER);
        }
    }
}


