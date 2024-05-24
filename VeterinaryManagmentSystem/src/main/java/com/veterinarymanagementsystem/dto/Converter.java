package com.veterinarymanagementsystem.dto;

import com.veterinarymanagementsystem.dto.request.DoctorRequest;
import com.veterinarymanagementsystem.dto.response.DoctorResponse;
import com.veterinarymanagementsystem.entities.Doctor;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public Doctor concertToDoctor(DoctorRequest DoctorRequest) {
        if (DoctorRequest == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setName(DoctorRequest.getName());
        doctor.setAddress(DoctorRequest.getAddress());
        doctor.setEmail(DoctorRequest.getEmail());
        doctor.setPhone(DoctorRequest.getPhone());
        return doctor;
    }
    public DoctorResponse toDoctorResponse(Doctor Doctor) {
                if (Doctor == null) {
                    return null;
                }
                DoctorResponse doctorResponse = new DoctorResponse();
                doctorResponse.setId(Doctor.getId());
                doctorResponse.setName(Doctor.getName());
                doctorResponse.setAddress(Doctor.getAddress());
                doctorResponse.setEmail(Doctor.getEmail());
                doctorResponse.setPhone(Doctor.getPhone());
                return doctorResponse;
    }
}
