package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.AppointmentRequest;
import com.veterinarymanagementsystem.dto.response.AppointmentResponse;
import com.veterinarymanagementsystem.entities.Animal;
import com.veterinarymanagementsystem.entities.Appointment;
import com.veterinarymanagementsystem.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper
public interface AppointmentMapper {
    @Mapping(target = "doctor", source = "doctorId")
    @Mapping(target = "animal", source = "animalId")
    Appointment asEntity (AppointmentRequest appointmentRequest);
    List<AppointmentResponse> asOutput(List<Appointment> appointment);
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "animal.id", target = "animalId")
    AppointmentResponse asOutput(Appointment appointment);
    void update(@MappingTarget Appointment entity, AppointmentRequest request);
    default Doctor mapDoctor(Long id) {
        if (id == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(id);
        return doctor;
    }
    default Animal mapAnimal(Long id) {
        if (id == null) {
            return null;
        }
        Animal animal = new Animal();
        animal.setId(id);
        return animal;
    }
}
