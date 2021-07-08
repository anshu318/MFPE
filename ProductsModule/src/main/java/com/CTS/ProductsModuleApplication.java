package com.CTS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsModuleApplication.class, args);
	}

}
