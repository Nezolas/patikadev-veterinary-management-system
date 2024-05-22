package com.veterinarymanagementsystem.dto.request;

import com.veterinarymanagementsystem.entities.Appointment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String diagnosis;
    @NotNull
    @PositiveOrZero
    private Double price;
    @NotNull
    private Appointment appointment;
}
