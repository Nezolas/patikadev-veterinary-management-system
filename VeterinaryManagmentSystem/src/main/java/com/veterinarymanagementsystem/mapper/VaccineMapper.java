package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.VaccineRequest;
import com.veterinarymanagementsystem.dto.response.VaccineResponse;
import com.veterinarymanagementsystem.entities.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface VaccineMapper {
    Vaccine asEntity(VaccineRequest vaccineRequest);
    VaccineResponse asOutput(Vaccine vaccine);
    List<VaccineResponse> asOutput(List<Vaccine> vaccine);
    void update(@MappingTarget Vaccine entity, VaccineRequest request);
}