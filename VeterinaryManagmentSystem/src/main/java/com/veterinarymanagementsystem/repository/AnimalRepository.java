package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Optional<Animal> findByCustomerIdAndName(Long customerId, String name);
    List<Animal> findByCustomerId(Long customerId);
    List<Animal> findByNameIgnoreCase(String name);
}