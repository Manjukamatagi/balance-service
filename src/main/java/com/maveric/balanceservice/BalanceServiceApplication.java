package com.maveric.balanceservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableFeignClients
public class BalanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalanceServiceApplication.class, args);
		System.out.println("hi this is balance service");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
