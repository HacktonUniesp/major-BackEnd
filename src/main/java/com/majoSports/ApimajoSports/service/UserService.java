package com.majoSports.ApimajoSports.service;

import com.majoSports.ApimajoSports.model.User;
import com.majoSports.ApimajoSports.model.dtos.UserRequest;
import com.majoSports.ApimajoSports.model.dtos.UserResponse;
import com.majoSports.ApimajoSports.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Log4j2
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public ResponseEntity<String> login(UserRequest userRequest){

        User user = userRepository.findByCpf(userRequest.getCpf());
        log.info("user={}",user);

        if (user == null){
            log.info("CPF ou email não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF ou Email não encontrado");

        }else{
            log.info("CPF {} existe.", user.getCpf());
            return ResponseEntity.status(HttpStatus.OK).body("Usuário autenticado com sucesso");
        }

//        User useSaved = userRepository.save(
//                new User(
//                        UUID.randomUUID(),
//                        userRequest.getLoginName(),
//                        userRequest.getPassword(),
//                        null));
    }

//    public UserResponse update (UUID id, UserRequest userRequest){
//
//        return  userRepository.findById(id)
//                .map(user -> {
////                    user.setLoginName(userRequest.getLoginName());
//                    user.setPassword(userRequest.getPassword());
//                    return new UserResponse(
////                            user.getLoginName(),
//                            user.getPassword()
//                    );
//                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID:" + id));
//
//    }

}
