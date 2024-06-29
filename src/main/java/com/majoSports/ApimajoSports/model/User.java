package com.majoSports.ApimajoSports.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String loginName;

    private String password;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
}
