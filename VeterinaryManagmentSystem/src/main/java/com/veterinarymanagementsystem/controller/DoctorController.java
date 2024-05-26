package com.veterinarymanagementsystem.controller;

import com.veterinarymanagementsystem.dto.request.DoctorRequest;
import com.veterinarymanagementsystem.dto.response.DoctorResponse;
import com.veterinarymanagementsystem.service.abstracts.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    // Yeni bir doktor kaydı oluşturmak için kullanılan endpoint
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse save(@RequestBody DoctorRequest request){
        return doctorService.create(request);
    }
    // Tüm doktorları listelemek için kullanılan endpoint
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorResponse> findAll(){
        return doctorService.findAll();
    }
    // Belirli bir doktorun bilgilerini getirmek için kullanılan endpoint
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse getById(@PathVariable("id") long id){
        return doctorService.getById(id);
    }
    // Mevcut bir doktor kaydını güncellemek için kullanılan endpoint
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse update(@PathVariable("id") long id, @RequestBody DoctorRequest request){
        return doctorService.update(id, request);
    }
    // Belirli bir doktor kaydını silmek için kullanılan endpoint
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        doctorService.deleteById(id);
    }
}
