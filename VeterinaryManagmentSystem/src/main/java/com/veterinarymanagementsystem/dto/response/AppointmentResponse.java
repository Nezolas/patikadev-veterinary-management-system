package com.veterinarymanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private Long id;
    private LocalDate appointmentDate;
    private Long doctorId;
    private Long animalId;

    /*    private Animal animal;
    private Doctor doctor;*/
}
