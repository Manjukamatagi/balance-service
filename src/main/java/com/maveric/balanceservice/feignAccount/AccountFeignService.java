package com.maveric.balanceservice.feignAccount;

import com.maveric.balanceservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "feignAccount",url = "http://localhost:3010/api/v1/")
public interface AccountFeignService {
    @GetMapping("/customers/{customerId}/customerAccounts")
    ResponseEntity<List<User>> getAccountsbyId(@PathVariable String customerId);}