package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.AppointmentRequest;
import com.veterinarymanagementsystem.dto.response.AppointmentResponse;
import com.veterinarymanagementsystem.entities.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper
public interface AppointmentMapper {
    Appointment asEntity (AppointmentRequest appointmentRequest);
    AppointmentResponse asOutput(Appointment appointment);
    List<AppointmentResponse> asOutput(List<Appointment> appointment);
    void update(@MappingTarget Appointment entity, AppointmentRequest request);
}
