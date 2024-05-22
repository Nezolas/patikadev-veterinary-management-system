package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
}