package com.majoSports.ApimajoSports.service;

import com.majoSports.ApimajoSports.model.User;
import com.majoSports.ApimajoSports.model.dtos.UserRequest;
import com.majoSports.ApimajoSports.model.dtos.UserResponse;
import com.majoSports.ApimajoSports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void create(UserRequest userRequest){

        User useSaved = userRepository.save(
                new User(
                        UUID.randomUUID(),
                        userRequest.getLoginName(),
                        userRequest.getPassword(),
                        null));
    }

    public UserResponse update (UUID id, UserRequest userRequest){

        return  userRepository.findById(id)
                .map(user -> {
                    user.setLoginName(userRequest.getLoginName());
                    user.setPassword(userRequest.getPassword());
                    return new UserResponse(
                            user.getLoginName(),
                            user.getPassword()
                    );
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID:" + id));

    }

}
