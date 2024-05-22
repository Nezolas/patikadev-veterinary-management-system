package com.veterinarymanagmentsystem.dto.response;

import com.veterinarymanagmentsystem.entities.Appointment;
import com.veterinarymanagmentsystem.entities.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    private Long id;
    private String title;
    private String diagnosis;
    private Double price;
    private Appointment appointment;
    private List<Vaccine> vaccine;
}
