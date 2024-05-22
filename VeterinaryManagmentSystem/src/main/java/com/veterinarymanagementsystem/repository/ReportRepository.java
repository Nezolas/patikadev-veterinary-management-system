package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findByAppointmentId(Long appointmentId);
}