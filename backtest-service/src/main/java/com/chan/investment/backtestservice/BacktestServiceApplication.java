package com.chan.investment.backtestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BacktestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacktestServiceApplication.class, args);
	}

}
