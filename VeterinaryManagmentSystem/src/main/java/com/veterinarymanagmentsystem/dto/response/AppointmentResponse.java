package com.veterinarymanagmentsystem.dto.response;

import com.veterinarymanagmentsystem.entities.Animal;
import com.veterinarymanagmentsystem.entities.Doctor;
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
