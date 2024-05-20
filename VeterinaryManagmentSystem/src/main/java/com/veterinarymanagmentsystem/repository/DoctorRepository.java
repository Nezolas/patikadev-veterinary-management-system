package com.veterinarymanagmentsystem.repository;

import com.veterinarymanagmentsystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}