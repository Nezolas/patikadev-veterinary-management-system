package com.veterinarymanagementsystem.controller;

import com.veterinarymanagementsystem.dto.request.AvailableDateRequest;
import com.veterinarymanagementsystem.dto.response.AvailableDateResponse;
import com.veterinarymanagementsystem.service.abstracts.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/available-date")
public class AvailableDateController {
    private final AvailableDateService availableDateService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateResponse> findAll(){
        return availableDateService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse getById(@PathVariable("id") long id){
        return availableDateService.getById(id);
    }

    @GetMapping("/date-range")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateResponse> getDoctorAvailableDateInRange(
            @RequestParam long doctorId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return availableDateService.getDoctorAvailableDateInRange(doctorId, startDate, endDate);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDateResponse save(@RequestBody AvailableDateRequest request){
        return availableDateService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse update(@PathVariable("id") long id, @RequestBody AvailableDateRequest request){
        return availableDateService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        availableDateService.deleteById(id);
    }
}
