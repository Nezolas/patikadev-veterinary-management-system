package com.veterinarymanagementsystem.controller;

import com.veterinarymanagementsystem.dto.request.ReportRequest;
import com.veterinarymanagementsystem.dto.response.ReportResponse;
import com.veterinarymanagementsystem.service.abstracts.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReportResponse> findAll(){
        return reportService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse getById(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReportResponse save(@RequestBody ReportRequest request) {
        return reportService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportResponse update(@PathVariable Long id, @RequestBody ReportRequest request) {
        return reportService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        reportService.deleteById(id);
    }
}
