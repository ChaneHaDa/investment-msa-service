package com.chan.investment.securitiesservice.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Stockinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    private String name;

    public Stockinfo() {
    }

    public Stockinfo(Long id, String number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

}
