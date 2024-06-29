package com.majoSports.ApimajoSports.model;

import com.majoSports.ApimajoSports.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Customer(UUID uuid, String name, String email, String cpf, UserType userType) {
    }
}
