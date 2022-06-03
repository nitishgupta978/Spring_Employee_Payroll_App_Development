package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
/**
 * @EnableSwagger2 use for Swagger
 */
@Slf4j
/**
 * Using Lombok for Logging ,Using just @Slf4j is enough to start using
 * the Logger
 */
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee payroll APP Started");

		/**
		 * return Employee payroll APP Started when complete the run configuration
		 */
	}
	@Bean
	public Docket productApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.employeepayrollapp"))
				.build();
		/**
		 * use @Bean is methode-level-annotation
		 * we create one method productApi and use Docket to connect our project between basePackage and  Swagger
		 * when provide url on browser http://localhost:8080/swagger-ui.html#/
		 */

	}
}
