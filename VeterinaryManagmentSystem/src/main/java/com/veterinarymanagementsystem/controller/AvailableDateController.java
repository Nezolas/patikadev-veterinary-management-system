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
    // Tüm müsait tarihleri listelemek için kullanılan endpoint
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateResponse> findAll(){
        return availableDateService.findAll();
    }
    // Belirli bir müsait tarihin bilgilerini getirmek için kullanılan endpoint
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse getById(@PathVariable("id") long id){
        return availableDateService.getById(id);
    }
    // Belirli bir doktorun belirli bir tarih aralığında müsait tarihlerini getirmek için kullanılan endpoint
    @GetMapping("/date-range")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateResponse> getDoctorAvailableDateInRange(
            @RequestParam long doctorId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ){
        return availableDateService.getDoctorAvailableDateInRange(doctorId, startDate, endDate);
    }
    // Yeni bir müsait tarih oluşturmak için kullanılan endpoint
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDateResponse save(@RequestBody AvailableDateRequest request){
        return availableDateService.create(request);
    }
    // Mevcut bir müsait tarihi güncellemek için kullanılan endpoint
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse update(@PathVariable("id") long id, @RequestBody AvailableDateRequest request){
        return availableDateService.update(id, request);
    }
    // Belirli bir müsait tarihi silmek için kullanılan endpoint
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        availableDateService.deleteById(id);
    }
}
