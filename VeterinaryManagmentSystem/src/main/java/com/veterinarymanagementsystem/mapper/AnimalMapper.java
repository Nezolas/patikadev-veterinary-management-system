package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.AnimalRequest;
import com.veterinarymanagementsystem.dto.response.AnimalResponse;
import com.veterinarymanagementsystem.entities.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AnimalMapper {
    Animal asEntity(AnimalRequest animalRequest);
    AnimalResponse asOutput(Animal animal);
    List<AnimalResponse> asOutput(List<Animal> animal);
    void update(@MappingTarget Animal entity, AnimalRequest request);
}
