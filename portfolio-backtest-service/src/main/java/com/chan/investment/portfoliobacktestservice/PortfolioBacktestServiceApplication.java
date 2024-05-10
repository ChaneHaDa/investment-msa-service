package com.chan.investment.portfoliobacktestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortfolioBacktestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBacktestServiceApplication.class, args);
	}

}
