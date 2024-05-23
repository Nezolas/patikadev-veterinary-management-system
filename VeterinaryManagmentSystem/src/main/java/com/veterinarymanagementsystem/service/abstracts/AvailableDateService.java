package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.request.AvailableDateRequest;
import com.veterinarymanagementsystem.dto.response.AvailableDateResponse;

import java.time.LocalDate;
import java.util.List;

public interface AvailableDateService {
    public List<AvailableDateResponse> findAll();
    public AvailableDateResponse getById(long id);
    public AvailableDateResponse create(AvailableDateRequest request);
    public AvailableDateResponse update(long id, AvailableDateRequest request);
    public void deleteById(long id);
    boolean existByDoctorIdAndAvailableDate(long doctorId, LocalDate availableDate);
    public List<AvailableDateResponse> getDoctorAvailableDateInRange(long doctorId, LocalDate startDate, LocalDate endDate);
}
