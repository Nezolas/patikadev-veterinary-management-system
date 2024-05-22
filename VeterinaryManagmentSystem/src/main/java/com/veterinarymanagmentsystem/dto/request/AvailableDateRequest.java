package com.veterinarymanagmentsystem.dto.request;

import com.veterinarymanagmentsystem.entities.Doctor;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDateRequest {
    @NotNull
    private LocalDate availableDate;
    @NotNull
    private Doctor doctor;
}
