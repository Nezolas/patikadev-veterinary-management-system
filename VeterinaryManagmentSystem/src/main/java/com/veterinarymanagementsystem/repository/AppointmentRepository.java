package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentDate(long doctorId, LocalDateTime appointmentDate);
    boolean existsByDoctorIdAndAppointmentDate(long doctorId, LocalDateTime appointmentDate);
    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime startDate, LocalDateTime endDate);
    List <Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);
}