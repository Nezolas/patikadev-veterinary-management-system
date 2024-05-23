package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.request.DoctorRequest;
import com.veterinarymanagementsystem.dto.response.DoctorResponse;

import java.util.List;

public interface DoctorService {
    public List<DoctorResponse> findAll();
    public DoctorResponse getById(long id);
    public DoctorResponse create(DoctorRequest request);
    public DoctorResponse update(long id, DoctorRequest request);
    public void deleteById(long id);
}
