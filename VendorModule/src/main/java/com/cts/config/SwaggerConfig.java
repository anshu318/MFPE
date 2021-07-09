package com.cts.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

//Configuration
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
//creating bean
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}