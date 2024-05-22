package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}