package com.majoSports.ApimajoSports.model;

import com.majoSports.ApimajoSports.enums.UserType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "customer")
    private User user;

}
