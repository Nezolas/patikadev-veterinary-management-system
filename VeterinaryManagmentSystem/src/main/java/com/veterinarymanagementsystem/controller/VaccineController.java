package com.veterinarymanagementsystem.controller;

import com.veterinarymanagementsystem.dto.request.VaccineRequest;
import com.veterinarymanagementsystem.dto.response.VaccineResponse;
import com.veterinarymanagementsystem.service.abstracts.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vaccines")
public class VaccineController {
    private final VaccineService vaccineService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAll(){
        return vaccineService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse getById(@PathVariable("id") long id){
        return vaccineService.getById(id);
    }

    @GetMapping("/animal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> getByAnimal(@PathVariable("id") long id){
        return vaccineService.getByAnimal(id);
    }

    @GetMapping("/date-range")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> getVaccineInDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return vaccineService.getVaccinesInDateRange(startDate, endDate);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineResponse save(@RequestBody VaccineRequest request){
        return vaccineService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse update(@PathVariable("id") long id, @RequestBody VaccineRequest request){
        return vaccineService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        vaccineService.deleteById(id);
    }
}
