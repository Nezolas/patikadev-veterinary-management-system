package com.veterinarymanagementsystem.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorResponse {
    private long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
}
