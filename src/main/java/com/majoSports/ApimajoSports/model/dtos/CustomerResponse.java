package com.majoSports.ApimajoSports.model.dtos;

import com.majoSports.ApimajoSports.enums.UserType;
import com.majoSports.ApimajoSports.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {

    private UUID id;

    private String name;

    private String email;

    private String cpf;

    private UserType userType;


}
