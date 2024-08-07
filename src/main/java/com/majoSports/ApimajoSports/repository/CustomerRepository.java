package com.majoSports.ApimajoSports.repository;

import com.majoSports.ApimajoSports.model.Customer;
import com.majoSports.ApimajoSports.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findByCpf(String cpf);
}
