package com.veterinarymanagementsystem.service.abstracts;

import com.veterinarymanagementsystem.dto.request.CustomerRequest;
import com.veterinarymanagementsystem.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    public List<CustomerResponse> findAll();
    public CustomerResponse getById(long id);
    public List<CustomerResponse> getByName(String name);
    public CustomerResponse create(CustomerRequest request);
    public CustomerResponse update(long id, CustomerRequest request);
    public void deleteById(long id);
}
