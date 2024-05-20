package com.veterinarymanagmentsystem.repository;

import com.veterinarymanagmentsystem.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}