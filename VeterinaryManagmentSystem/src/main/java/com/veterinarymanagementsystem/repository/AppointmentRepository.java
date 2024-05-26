package com.veterinarymanagementsystem.repository;

import com.veterinarymanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentDate(Long doctor_id, LocalDate appointmentDate);
    boolean existsByDoctorIdAndAppointmentDate(Long doctor_id, LocalDate appointmentDate);
    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animal_id, LocalDate appointmentDate, LocalDate appointmentDate2);
    List <Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctor_id, LocalDate appointmentDate, LocalDate appointmentDate2);
}