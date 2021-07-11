package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

/*
 * Vendor Microservice
 * */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class VendorModuleApplication {

	public static void main(String[] args) {
		log.info("Main started...");
		SpringApplication.run(VendorModuleApplication.class, args);
		log.info("Main ended...");
	}

}
