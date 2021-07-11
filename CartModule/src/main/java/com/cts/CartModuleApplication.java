package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
/*
 * Cart Microservice
 * */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CartModuleApplication {

	public static void main(String[] args) {
		log.info("Main started...");
		SpringApplication.run(CartModuleApplication.class, args);
		log.info("Main ended...");
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}	
	
}
