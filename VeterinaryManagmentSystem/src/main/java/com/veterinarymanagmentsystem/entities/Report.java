package com.veterinarymanagmentsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "report")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;
    private String title;
    private String diagnosis;

    @NotNull
    @PositiveOrZero
    private Double price;

    @OneToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id")
    private Appointment appointment;

    @OneToMany(mappedBy = "report", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccine;
}
