package com.majoSports.ApimajoSports.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private String loginName;
    private String password;
}
