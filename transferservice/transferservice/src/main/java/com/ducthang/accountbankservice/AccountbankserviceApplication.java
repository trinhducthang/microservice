package com.ducthang.accountbankservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AccountbankserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountbankserviceApplication.class, args);
	}

}
