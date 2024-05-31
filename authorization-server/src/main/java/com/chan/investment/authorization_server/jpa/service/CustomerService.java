package com.chan.investment.authorization_server.jpa.service;

import com.chan.investment.authorization_server.jpa.dto.CustomerDTO;
import com.chan.investment.authorization_server.jpa.entity.Customer;
import com.chan.investment.authorization_server.jpa.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerDTO createCustomer(CustomerDTO customer) {
        Customer _customer = new Customer();
        _customer.setUsername(customer.getUsername());
        _customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        _customer.setRole("USER");
        return CustomerDTO.fromEntity(customerRepository.save(_customer));
    }
}
