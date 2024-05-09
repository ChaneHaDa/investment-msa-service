package com.chan.investment.portfoliocompositionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortfolioCompositionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioCompositionServiceApplication.class, args);
	}

}
