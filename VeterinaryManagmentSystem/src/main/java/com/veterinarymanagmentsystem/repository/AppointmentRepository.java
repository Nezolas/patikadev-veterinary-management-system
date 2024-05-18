package com.veterinarymanagmentsystem.repository;

import com.veterinarymanagmentsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}