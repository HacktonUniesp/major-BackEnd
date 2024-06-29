package com.majoSports.ApimajoSports.repository;

import com.majoSports.ApimajoSports.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerModel extends JpaRepository<Customer, UUID> {
}
