package com.majoSports.ApimajoSports.service;

import com.majoSports.ApimajoSports.model.Customer;
import com.majoSports.ApimajoSports.model.dtos.CustomerRequest;
import com.majoSports.ApimajoSports.model.dtos.CustomerResponse;
import com.majoSports.ApimajoSports.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse create(CustomerRequest customerRequest){

//         Customer customer =
//             new Customer(UUID.randomUUID(),
//                     customerRequest.getName(),
//                     customerRequest.getEmail(),
//                     customerRequest.getCpf(),
//                     customerRequest.getUserType()
//
//     );
         Customer customerSaved = customerRepository.save(new Customer(UUID.randomUUID(),
                 customerRequest.getName(),
                 customerRequest.getEmail(),
                 customerRequest.getCpf(),
                 customerRequest.getUserType()));

        return new CustomerResponse(
             customerSaved.getId(),
             customerSaved.getName(),
             customerSaved.getEmail(),
             customerSaved.getCpf(),
             customerSaved.getUserType()
     );

 }
 public List<CustomerResponse> findAll(){
      return  customerRepository.findAll()
                .stream()
                .map(customer -> new CustomerResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getCpf(),
                        customer.getUserType()
                )).collect(Collectors.toList());
 }

 public CustomerResponse findById(UUID id){
        return customerRepository.findById(id)
                .map(customer -> new CustomerResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getCpf(),
                        customer.getUserType()
                )).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer not found with ID: " + id));
 }

 public CustomerResponse update (UUID id, CustomerRequest customerRequest){

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerRequest.getName());
                    customer.setEmail(customerRequest.getEmail());
                    customer.setCpf(customerRequest.getCpf());
                    customer.setUserType(customerRequest.getUserType());
                    customerRepository.save(customer);
                    return new CustomerResponse(
                            customer.getId(),
                            customer.getName(),
                            customer.getEmail(),
                            customer.getCpf(),
                            customer.getUserType()
                    );
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found with ID:" + id));
 }

 public void deleteById(UUID id){
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Customer not found with ID:" + id);
        }
 }



}
