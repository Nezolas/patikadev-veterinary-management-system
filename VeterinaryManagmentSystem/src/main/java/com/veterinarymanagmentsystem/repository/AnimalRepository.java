package com.veterinarymanagmentsystem.repository;

import com.veterinarymanagmentsystem.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}