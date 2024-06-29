package com.majoSports.ApimajoSports.model.dtos;

import com.majoSports.ApimajoSports.enums.UserType;
import com.majoSports.ApimajoSports.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequest {

    private String name;

    private String email;

    private String cpf;

    private UserType userType;

    private String loginName;

    private String password;

}
