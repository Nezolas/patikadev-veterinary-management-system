package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, long animalId);
    List<Vaccine> findByAnimalId(long animalId);
    List<Vaccine> findByProtectionEndDateBetween(LocalDate startDate, LocalDate endDate);
}