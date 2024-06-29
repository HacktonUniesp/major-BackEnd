package com.majoSports.ApimajoSports.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String loginName;

    private String password;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Customer customer;
}
