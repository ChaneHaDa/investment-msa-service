package com.chan.investment.authorization_server.jpa.service;

import com.chan.investment.authorization_server.jpa.entity.Customer;
import com.chan.investment.authorization_server.jpa.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerSecurityService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public CustomerSecurityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> _customer = customerRepository.findByusername(username);
        if (_customer.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        Customer customer = _customer.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getUsername(), customer.getPassword(), authorities);
    }
}
