package com.veterinarymanagmentsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "animal")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private long id;
    private String name;
    private String species;
    private String breed;
    private String color;
    private LocalDate dateOfBirth;
    private String colour;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    public enum Gender {
        MALE,
        FEMALE
    }
}
