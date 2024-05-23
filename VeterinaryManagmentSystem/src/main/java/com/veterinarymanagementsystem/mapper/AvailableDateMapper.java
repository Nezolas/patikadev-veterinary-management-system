package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.AvailableDateRequest;
import com.veterinarymanagementsystem.dto.response.AvailableDateResponse;
import com.veterinarymanagementsystem.entities.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AvailableDateMapper {
    AvailableDate asEntity(AvailableDateRequest availableDateRequest);
    AvailableDateResponse asOutput(AvailableDate availableDate);
    List<AvailableDateResponse> asOutput(List<AvailableDate> availableDate);
    void update(@MappingTarget AvailableDate entity, AvailableDateRequest request);
}
