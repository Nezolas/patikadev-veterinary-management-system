package com.veterinarymanagmentsystem.dto.request;

import com.veterinarymanagmentsystem.entities.Animal;
import com.veterinarymanagmentsystem.entities.Report;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineRequest {
    @NotBlank
    private String name;
    @NotNull
    private String code;
    @NotNull
    private LocalDate protectionStartDate;
    @NotNull
    private LocalDate protectionEndDate;
    @NotNull
    private Animal animal;
    @NotNull
    private Report report;
}
