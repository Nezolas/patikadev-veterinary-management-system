package com.veterinarymanagmentsystem.repository;

import com.veterinarymanagmentsystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}