package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.request.ReportRequest;
import com.veterinarymanagementsystem.dto.response.ReportResponse;

import java.util.List;

public interface ReportService {
    List<ReportResponse> findAll();
    ReportResponse getById(Long id);
    ReportResponse create(ReportRequest request);
    ReportResponse update(Long id, ReportRequest request);
    void deleteById(Long id);
}
