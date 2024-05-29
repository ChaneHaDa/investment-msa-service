package com.chan.investment.authorization_server.jpa.dto;

import com.chan.investment.authorization_server.jpa.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {
    @NotBlank
    private String username;
    @NotBlank
    @JsonIgnore
    private String password;

    public CustomerDTO() {
    }

    public CustomerDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static CustomerDTO fromEntity(Customer customer) {
        return new CustomerDTO(customer.getUsername(), customer.getPassword());
    }
}
