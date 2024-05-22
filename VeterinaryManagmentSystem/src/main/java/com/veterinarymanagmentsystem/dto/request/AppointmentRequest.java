package com.veterinarymanagmentsystem.dto.request;

import com.veterinarymanagmentsystem.entities.Animal;
import com.veterinarymanagmentsystem.entities.Doctor;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    @NotNull
    private LocalDateTime appointmentDate;
    @NotNull
    private Animal animal;
    @NotNull
    private Doctor doctor;
}