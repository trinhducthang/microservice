package com.win.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Discovery_serverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Discovery_serverApplication.class, args);
	}

}
