package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.dto.request.AppointmentRequest;
import com.veterinarymanagementsystem.dto.response.AppointmentResponse;
import com.veterinarymanagementsystem.entities.Appointment;
import com.veterinarymanagementsystem.mapper.AppointmentMapper;
import com.veterinarymanagementsystem.repository.AppointmentRepository;
import com.veterinarymanagementsystem.service.abstracts.AppointmentService;
import com.veterinarymanagementsystem.service.abstracts.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateManager;

    @Override
    public List<AppointmentResponse> findAll() {
        return appointmentMapper.asOutput(appointmentRepository.findAll());
    }

    @Override
    public AppointmentResponse getById(Long id) {
        return appointmentMapper.asOutput(appointmentRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }

    @Override
    public AppointmentResponse create(AppointmentRequest request) {
        if (!availableDateManager.existByDoctorIdAndAvailableDate(request.getDoctorId(), request.getAppointmentDate().toLocalDate())){
            throw new NotFoundException(Msg.APPOINMENT_NOT_FOUND);
        }
        if (!isDoctorAvailableAtTime(request.getAnimalId(), request.getAppointmentDate())){
            throw new NotFoundException(Msg.APPOINMENT_NOT_FOUND);
        }
        Appointment appointmentSaved = appointmentRepository.save(appointmentMapper.asEntity(request));
        return appointmentMapper.asOutput(appointmentSaved);
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentRequest request) {
        Optional<Appointment> appointmentFromDb = appointmentRepository.findById(id);
        if (appointmentFromDb.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        Optional<Appointment> newAppointment = appointmentRepository.findByDoctorIdAndAppointmentDate(request.getDoctorId(), request.getAppointmentDate());
        if (newAppointment.isPresent() && newAppointment.get().getId() != id){
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        Appointment appointment = appointmentFromDb.get();
        appointmentMapper.update(appointment, request);
        return appointmentMapper.asOutput(appointmentRepository.save(appointment));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Appointment> appointmentFromDb = appointmentRepository.findById(id);
        if (appointmentFromDb.isPresent()){
            appointmentRepository.delete(appointmentFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }

    @Override
    public boolean isDoctorAvailableAtTime(Long doctorId, LocalDateTime appointmentDate) {
        return !appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId, appointmentDate);
    }

    @Override
    public List<AppointmentResponse> getAnimalAppointmentDateInRange(Long animalId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.MAX);
        return appointmentMapper.asOutput(appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, startDateTime, endDateTime));
    }

    @Override
    public List<AppointmentResponse> getDoctorAppointmentDateInRange(Long doctorId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.MAX);
        return appointmentMapper.asOutput(appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, startDateTime, endDateTime));
    }

}
