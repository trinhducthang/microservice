package com.ducthang.bank_service;

import com.ducthang.bank_service.service.BankServiceItf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankServiceApplication {
    public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}

}
