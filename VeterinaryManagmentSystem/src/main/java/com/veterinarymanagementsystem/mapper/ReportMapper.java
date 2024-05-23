package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.ReportRequest;
import com.veterinarymanagementsystem.dto.response.ReportResponse;
import com.veterinarymanagementsystem.entities.Report;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ReportMapper {
    Report asEntity(ReportRequest request);
    ReportResponse asOutput(Report report);
    List<ReportResponse> asOutput(List<Report> reports);
    void update(@MappingTarget Report entity, ReportRequest request);
}
