package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.DoctorRequest;
import com.veterinarymanagementsystem.dto.response.DoctorResponse;
import com.veterinarymanagementsystem.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface DoctorMapper {
    Doctor asEntity(DoctorRequest doctorRequest);
    DoctorResponse asOutput(Doctor doctor);
    List<DoctorResponse> asOutput(List<Doctor> doctor);
    void update (@MappingTarget Doctor entity, DoctorRequest request);
}
