package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}