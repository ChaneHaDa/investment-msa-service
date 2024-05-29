package com.chan.investment.authorization_server;

import com.chan.investment.authorization_server.jpa.entity.Customer;
import com.chan.investment.authorization_server.jpa.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class AuthorizationServerApplicationTests {

	@Autowired
	CustomerService customerService;

	@Autowired
	PasswordEncoder passwordEncoder;

//	@Test
//	void contextLoads() {
//		Customer customer = new Customer();
//		customer.setUsername("admin");
//		customer.setPassword("1234");
//		customer.setRole("USER");
//		customerService.createCustomer(customer);
//	}

}
