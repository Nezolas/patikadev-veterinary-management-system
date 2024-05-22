package com.veterinarymanagmentsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "vaccine")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private Long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionEndDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", referencedColumnName = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    private Report report;
}
