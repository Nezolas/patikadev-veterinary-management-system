package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.request.VaccineRequest;
import com.veterinarymanagementsystem.dto.response.VaccineResponse;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    public List<VaccineResponse> findAll();
    public VaccineResponse getById(long id);
    public List<VaccineResponse> getByAnimal(long id);
    public List<VaccineResponse> getVaccinesInDateRange(LocalDate startDate, LocalDate endDate);
    public VaccineResponse create(VaccineRequest request);
    public VaccineResponse update(long id, VaccineRequest request);
    public void deleteById(long id);
}
