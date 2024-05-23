package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.dto.request.ReportRequest;
import com.veterinarymanagementsystem.dto.response.ReportResponse;
import com.veterinarymanagementsystem.entities.Report;
import com.veterinarymanagementsystem.mapper.ReportMapper;
import com.veterinarymanagementsystem.repository.ReportRepository;
import com.veterinarymanagementsystem.service.abstracts.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportManager implements ReportService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public List<ReportResponse> findAll() {
        reportRepository.findAll();
        return reportMapper.asOutput(reportRepository.findAll());
    }

    @Override
    public ReportResponse getById(Long id) {
        return reportMapper.asOutput(reportRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }

    @Override
    public ReportResponse create(ReportRequest request) {
        Optional<Report> isReportExist = reportRepository.findByAppointmentId(request.getAppointment().getId());
        if (isReportExist.isEmpty()){
            Report reportSaved = reportRepository.save(reportMapper.asEntity(request));
            return reportMapper.asOutput(reportSaved);
        }
        throw new DataExistsException(Msg.DATA_EXISTS);
    }

    @Override
    public ReportResponse update(Long id, ReportRequest request) {
        Optional<Report> reportFromDb = reportRepository.findById(id);
        if (reportFromDb.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        Long newAppointmentId = request.getAppointment().getId();
        Optional<Report> newReport = reportRepository.findByAppointmentId(newAppointmentId);
        if (newReport.isPresent() && newReport.get().getId() != id) {
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        Report report = reportFromDb.get();
        reportMapper.update(report, request);
        return reportMapper.asOutput(reportRepository.save(report));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Report> reportFromDb = reportRepository.findById(id);
        if (reportFromDb.isPresent()) {
            reportRepository.delete(reportFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }
}
