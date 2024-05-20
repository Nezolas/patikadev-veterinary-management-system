package com.veterinarymanagmentsystem.repository;

import com.veterinarymanagmentsystem.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}