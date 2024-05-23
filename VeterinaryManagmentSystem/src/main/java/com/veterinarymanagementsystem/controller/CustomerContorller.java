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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") long id){
        return customerService.getById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getByName(@PathVariable("name") String name){
        return customerService.getByName(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody CustomerRequest request){
        return customerService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable("id") long id, @RequestBody CustomerRequest request){
        return customerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        customerService.deleteById(id);
    }
}
