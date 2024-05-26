package com.veterinarymanagementsystem.controller;

import com.veterinarymanagementsystem.dto.request.CustomerRequest;
import com.veterinarymanagementsystem.dto.response.CustomerResponse;
import com.veterinarymanagementsystem.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerContorller {
    private final CustomerService customerService;
    // Tüm müşterileri listelemek için kullanılan endpoint
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }
    // Belirli bir müşterinin bilgilerini getirmek için kullanılan endpoint
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") long id){
        return customerService.getById(id);
    }
    // Belirli bir isimle eşleşen müşterileri getirmek için kullanılan endpoint
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getByName(@PathVariable("name") String name){
        return customerService.getByName(name);
    }
    // Yeni bir müşteri oluşturmak için kullanılan endpoint
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody CustomerRequest request){
        return customerService.create(request);
    }
    // Mevcut bir müşteriyi güncellemek için kullanılan endpoint
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable("id") long id, @RequestBody CustomerRequest request){
        return customerService.update(id, request);
    }
    // Belirli bir müşteriyi silmek için kullanılan endpoint
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        customerService.deleteById(id);
    }
}
