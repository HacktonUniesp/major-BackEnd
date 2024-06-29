package com.majoSports.ApimajoSports.controller;

import com.majoSports.ApimajoSports.model.dtos.UserRequest;
import com.majoSports.ApimajoSports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void login(@RequestBody UserRequest userRequest){
        userService.login(userRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
//        userService.update(id, userRequest);
    }

}
