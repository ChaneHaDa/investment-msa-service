package com.chan.investment.authorization_server.jpa.controller;

import com.chan.investment.authorization_server.jpa.dto.CustomerDTO;
import com.chan.investment.authorization_server.jpa.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO registerCustomer(@Valid CustomerDTO customer) {
        return customerService.createCustomer(customer);
    }
}
