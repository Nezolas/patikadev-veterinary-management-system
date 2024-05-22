package com.veterinarymanagmentsystem.dto.response;

import com.veterinarymanagmentsystem.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDateResponse {
    private Long id;
    private LocalDate availableDate;
    private Doctor doctor;
}
