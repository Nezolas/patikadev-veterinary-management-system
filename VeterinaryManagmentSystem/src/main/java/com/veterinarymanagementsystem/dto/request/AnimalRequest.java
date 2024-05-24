package com.veterinarymanagementsystem.dto.request;

import com.veterinarymanagementsystem.entities.Animal;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String breed;
    @NotBlank
    private String species;
    @NotBlank
    private String color;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Animal.Gender gender;
    public enum Gender{
        MALE, FEMALE
    }
    @NotNull
    private Long customerId;
}
