package com.veterinarymanagementsystem.mapper;

import com.veterinarymanagementsystem.dto.request.CustomerRequest;
import com.veterinarymanagementsystem.dto.response.CustomerResponse;
import com.veterinarymanagementsystem.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper
public interface CustomerMapper {
    Customer asEntity(CustomerRequest customerRequest);
    CustomerResponse asOutput(Customer customer);
    List<CustomerResponse> asOutput(List<Customer> customer);
    void update(@MappingTarget Customer entity, CustomerRequest request);
}
