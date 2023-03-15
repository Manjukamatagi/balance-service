package com.maveric.balanceservice.feignAccount;

import com.maveric.balanceservice.dto.AccountDto;
import com.maveric.balanceservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value = "account-service")

public interface AccountFeignService {

    @GetMapping("api/v1/customers/{customerId}/customerAccounts")
    ResponseEntity<List<User>> getAccountsbyId(@PathVariable String customerId);

    @GetMapping("api/v1/customers/customerId/accounts/{accountId}")
    public AccountDto getAccountByUserId(@PathVariable("accountId") String accountId,
                                         @RequestHeader(value = "userid") String headerUserId);}



