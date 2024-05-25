package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.request.AppointmentRequest;
import com.veterinarymanagementsystem.dto.response.AppointmentResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    public List<AppointmentResponse> findAll();
    public AppointmentResponse getById(Long id);
    public AppointmentResponse create(AppointmentRequest request);
    public AppointmentResponse update(Long id, AppointmentRequest request);
    public void deleteById(Long id);
    public boolean isDoctorAvailableAtTime(Long doctorId, LocalDateTime appointmentDate);
    public List<AppointmentResponse> getAnimalAppointmentDateInRange(Long animalId, LocalDate startDate, LocalDate endDate);
    public List<AppointmentResponse> getDoctorAppointmentDateInRange(Long doctorId, LocalDate startDate, LocalDate endDate);
}
