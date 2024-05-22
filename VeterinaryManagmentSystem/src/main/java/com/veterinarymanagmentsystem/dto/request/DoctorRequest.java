package com.veterinarymanagmentsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
    @NotBlank
    private String name;
    //Pattern(regexp = "\\d{10} anotasyon 10 haneli karakter girilmesini zorunlu tutar d: digit (0-9), {10}: 10 karakterli dizi
    @Pattern(regexp = "\\d{10}", message = "Telefon numarası 10 karakterden oluşmalı")
    @Email
    private String mail;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
}