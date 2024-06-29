package com.majoSports.ApimajoSports.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

    private String cpf;

    private String password;
}
