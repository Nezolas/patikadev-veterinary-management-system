package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.response.AnimalResponse;
import com.veterinarymanagementsystem.dto.request.AnimalRequest;

import java.util.List;

public interface AnimalService {
    List<AnimalResponse> findAll();
    AnimalResponse getById(Long id);
    List<AnimalResponse> getByCustomer(Long id);
    AnimalResponse create(AnimalRequest request);
    AnimalResponse update(Long id, AnimalRequest request);
    void deleteById(Long id);
    List<AnimalResponse> getByName(String name);
}
