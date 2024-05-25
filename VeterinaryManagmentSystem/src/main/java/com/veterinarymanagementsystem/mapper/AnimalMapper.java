package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.AnimalRequest;
import com.veterinarymanagementsystem.dto.response.AnimalResponse;
import com.veterinarymanagementsystem.entities.Animal;
import com.veterinarymanagementsystem.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AnimalMapper {

    List<AnimalResponse> asOutputList(List<Animal> animals);
    @Mapping(target = "customer", source = "customerId")
    Animal asEntity(AnimalRequest animalRequest);
    @Mapping(source = "customer.id", target = "customerId")
    AnimalResponse asOutput(Animal animal);

    List<AnimalResponse> asOutput(List<Animal> animal);
    void update(@MappingTarget Animal entity, AnimalRequest request);
    default Customer map(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }

}