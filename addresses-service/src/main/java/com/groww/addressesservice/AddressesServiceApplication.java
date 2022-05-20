package com.groww.addressesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddressesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressesServiceApplication.class, args);
	}

}
