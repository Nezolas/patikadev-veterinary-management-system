package com.veterinarymanagementsystem.controller;

import com.veterinarymanagementsystem.dto.request.AppointmentRequest;
import com.veterinarymanagementsystem.dto.response.AppointmentResponse;
import com.veterinarymanagementsystem.service.abstracts.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse getById(@PathVariable("id") long id){
        return appointmentService.getById(id);
    }

    @GetMapping("/animal/date-range")
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> getAnimalAppointmentDateInRange(
            @RequestParam long animalId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return appointmentService.getAnimalAppointmentDateInRange(animalId, startDate, endDate);
    }

    @GetMapping("/doctor/date-range")
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> getDoctorAppointmentDateInRange(
            @RequestParam long doctorId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return appointmentService.getDoctorAppointmentDateInRange(doctorId, startDate, endDate);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@RequestBody AppointmentRequest request){
        return appointmentService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable("id") long id, @RequestBody AppointmentRequest request){
        return appointmentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        appointmentService.deleteById(id);
    }
}
