package com.majoSports.ApimajoSports.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    private BigDecimal value;

    private String appName;
}
