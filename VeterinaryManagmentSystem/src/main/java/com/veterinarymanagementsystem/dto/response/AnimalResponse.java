package com.veterinarymanagementsystem.dto.response;

import com.veterinarymanagementsystem.entities.Animal;
import com.veterinarymanagementsystem.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String color;
    private Animal.Gender gender;
    private LocalDate birthDate;
    private Customer customer;
}