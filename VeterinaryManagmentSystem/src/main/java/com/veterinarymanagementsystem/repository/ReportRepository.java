package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}