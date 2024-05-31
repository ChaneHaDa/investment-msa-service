package com.chan.investment.authorization_server.jpa.repository;

import com.chan.investment.authorization_server.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByusername(String username);
}
