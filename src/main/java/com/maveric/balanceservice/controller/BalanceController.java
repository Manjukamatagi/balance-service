package com.maveric.balanceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "accounts")
public class BalanceController {
    @GetMapping(value = "/hello")
    public String SayHello(){
        return "Hello this is from balance service";
    }
}
