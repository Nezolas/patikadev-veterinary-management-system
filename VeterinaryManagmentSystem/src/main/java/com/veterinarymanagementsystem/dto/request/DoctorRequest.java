package com.veterinarymanagementsystem.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorRequest {
    @NotBlank
    private String name;
   /* //Pattern(regexp = "\\d{10} anotasyon 10 haneli karakter girilmesini zorunlu tutar d: digit (0-9), {10}: 10 karakterli dizi
    @Pattern(regexp = "\\d{10}", message = "Telefon numarası 10 karakterden oluşmalı")*/
    @NotNull
    private String phone;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
}