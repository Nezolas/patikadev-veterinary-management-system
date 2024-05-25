package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.AppointmentRequest;
import com.veterinarymanagementsystem.dto.response.AppointmentResponse;
import com.veterinarymanagementsystem.entities.Appointment;
import com.veterinarymanagementsystem.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper
public interface AppointmentMapper {
    @Mapping(target = "doctor", source = "doctorId")
    Appointment asEntity (AppointmentRequest appointmentRequest);
    List<AppointmentResponse> asOutput(List<Appointment> appointment);
    @Mapping(source = "doctor.id", target = "doctorId")
    AppointmentResponse asOutput(Appointment appointment);
    void update(@MappingTarget Appointment entity, AppointmentRequest request);
    default Doctor map(Long id) {
        if (id == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(id);
        return doctor;
    }
}
