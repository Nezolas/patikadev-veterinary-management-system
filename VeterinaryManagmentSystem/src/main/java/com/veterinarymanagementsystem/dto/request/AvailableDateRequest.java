package com.veterinarymanagementsystem.dto.request;

import com.veterinarymanagementsystem.entities.Doctor;
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
