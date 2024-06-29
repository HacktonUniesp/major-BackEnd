package com.majoSports.ApimajoSports.controller;

import com.majoSports.ApimajoSports.model.Customer;
import com.majoSports.ApimajoSports.model.dtos.CustomerRequest;
import com.majoSports.ApimajoSports.model.dtos.CustomerResponse;
import com.majoSports.ApimajoSports.model.dtos.UserRequest;
import com.majoSports.ApimajoSports.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CustomerRequest customerRequest){
       return customerService.create(customerRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> login(@RequestBody UserRequest userRequest){
        return customerService.login(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAll(){
      return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse findById(@RequestParam  UUID id){
        return customerService.findById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam UUID id){
        customerService.deleteById(id);
    }

}
