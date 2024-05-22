package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}