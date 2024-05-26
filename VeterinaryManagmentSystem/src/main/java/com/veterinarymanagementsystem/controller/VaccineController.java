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

    // Tüm aşıları listelemek için kullanılan endpoint
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAll(){
        return vaccineService.findAll();
    }
    // Belirli bir aşının bilgilerini getirmek için kullanılan endpoint
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse getById(@PathVariable("id") long id){
        return vaccineService.getById(id);
    }
    // Belirli bir hayvana ait aşıları getirmek için kullanılan endpoint
    @GetMapping("/animal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> getByAnimal(@PathVariable("id") long id){
        return vaccineService.getByAnimal(id);
    }
    // Belirli bir tarih aralığında yapılan aşıları getirmek için kullanılan endpoint
    @GetMapping("/date-range")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> getVaccineInDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return vaccineService.getVaccinesInDateRange(startDate, endDate);
    }
    // Yeni bir aşı kaydı oluşturmak için kullanılan endpoint
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineResponse save(@RequestBody VaccineRequest request){
        return vaccineService.create(request);
    }
    // Mevcut bir aşı kaydını güncellemek için kullanılan endpoint
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse update(@PathVariable("id") long id, @RequestBody VaccineRequest request){
        return vaccineService.update(id, request);
    }
    // Belirli bir aşı kaydını silmek için kullanılan endpoint
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        vaccineService.deleteById(id);
    }
}
