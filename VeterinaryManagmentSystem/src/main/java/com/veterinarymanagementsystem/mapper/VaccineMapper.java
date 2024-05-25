package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.VaccineRequest;
import com.veterinarymanagementsystem.dto.response.VaccineResponse;
import com.veterinarymanagementsystem.entities.Animal;
import com.veterinarymanagementsystem.entities.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface VaccineMapper {
    @Mapping(target = "animal", source = "animalId")
    Vaccine asEntity(VaccineRequest vaccineRequest);
    @Mapping(source = "animal.id", target = "animalId")
    VaccineResponse asOutput(Vaccine vaccine);
    List<VaccineResponse> asOutput(List<Vaccine> vaccine);
    void update(@MappingTarget Vaccine entity, VaccineRequest request);
    default Animal map(Long id) {
        if (id == null) {
            return null;
        }
        Animal animal = new Animal();
        animal.setId(id);
        return animal;
    }
}