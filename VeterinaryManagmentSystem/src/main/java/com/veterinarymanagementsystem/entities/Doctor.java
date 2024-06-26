package com.veterinarymanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Table(name = "doctor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;
    private String name;
    @Column(nullable = false)
    @Email
    private String email;
    private String address;
    private String city;
    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDate; // Doktora ait uygun tarihler listesi

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointment;  // Doktora ait randevular listesi
}
