package com.veterinarymanagementsystem.dto.response;

import com.veterinarymanagementsystem.entities.Animal;
import com.veterinarymanagementsystem.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private long id;
    private LocalDateTime appointmentDate;
    private Animal animal;
    private Doctor doctor;
}
