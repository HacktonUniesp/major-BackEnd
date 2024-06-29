package com.majoSports.ApimajoSports.service;

import com.majoSports.ApimajoSports.model.Customer;
import com.majoSports.ApimajoSports.model.User;
import com.majoSports.ApimajoSports.model.dtos.CustomerRequest;
import com.majoSports.ApimajoSports.model.dtos.CustomerResponse;
import com.majoSports.ApimajoSports.model.dtos.UserRequest;
import com.majoSports.ApimajoSports.repository.CustomerRepository;
import com.majoSports.ApimajoSports.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    public CustomerResponse create(CustomerRequest customerRequest){

        log.info("Processando a requisição para cadastro de novo usuario. - {}", customerRequest.getCpf());
         Customer customerSaved = customerRepository.save(
                 new Customer(
                         UUID.randomUUID(),
                        customerRequest.getName(),
                        customerRequest.getEmail(),
                        customerRequest.getCpf(),
                        customerRequest.getUserType(),
                         null));

        log.info("Usuário email={} CPF={} do tipo {} cadastrado com sucesso.",
                customerRequest.getEmail(),
                customerRequest.getCpf(),
                customerRequest.getUserType());

        User userSaved = userRepository.save(
                new User(
                        UUID.randomUUID(),
                        customerRequest.getCpf(),
                        customerRequest.getPassword(),
                        null
                )
        );
        log.info("Usuário cpf={} salvo com sucesso.", userSaved.getCpf());

        return new CustomerResponse(
             customerSaved.getId(),
             customerSaved.getName(),
             customerSaved.getEmail(),
             customerSaved.getCpf(),
             customerSaved.getUserType()
     );

 }

    public ResponseEntity<Customer> login(UserRequest userRequest){

        Customer customer = customerRepository.findByCpf(userRequest.getCpf());
        log.info("user={}",customer);

        if (customer == null){
            log.info("CPF ou email não encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customer);

        }else{
            log.info("CPF {} existe.", customer.getCpf());
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }

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
