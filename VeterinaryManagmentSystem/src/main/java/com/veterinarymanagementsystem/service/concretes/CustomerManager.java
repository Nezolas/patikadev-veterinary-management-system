package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.dto.request.CustomerRequest;
import com.veterinarymanagementsystem.dto.response.CustomerResponse;
import com.veterinarymanagementsystem.entities.Customer;
import com.veterinarymanagementsystem.mapper.CustomerMapper;
import com.veterinarymanagementsystem.repository.CustomerRepository;
import com.veterinarymanagementsystem.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> findAll() {
        return customerMapper.asOutput(customerRepository.findAll());
    }

    @Override
    public CustomerResponse getById(long id) {
        return customerMapper.asOutput(customerRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }


    @Override
    public List<CustomerResponse> getByName(String name) {
        if (customerRepository.findByNameIgnoreCase(name).isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return customerMapper.asOutput(customerRepository.findByNameIgnoreCase(name));
    }

    @Override
    public CustomerResponse create(CustomerRequest request) {
        Optional<Customer> isCustomerExist = customerRepository.findByEmail(request.getEmail());
        if (isCustomerExist.isEmpty()){
            Customer customerSaved = customerRepository.save(customerMapper.asEntity(request));
            return customerMapper.asOutput(customerSaved);
        }
        throw new DataExistsException(Msg.DATA_EXISTS);
    }

    @Override
    public CustomerResponse update(long id, CustomerRequest request) {
        Optional<Customer> customerFromDb = customerRepository.findById(id);
        if (customerFromDb.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        String newMail = request.getEmail();
        Optional<Customer> newCustomer = customerRepository.findByEmail(newMail);
        if (newCustomer.isPresent() && newCustomer.get().getId() != id){
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        Customer customer = customerFromDb.get();
        customerMapper.update(customer, request);
        return customerMapper.asOutput(customerRepository.save(customer));
    }

    @Override
    public void deleteById(long id) {
        Optional<Customer> customerFromDb = customerRepository.findById(id);
        if (customerFromDb.isPresent()){
            customerRepository.delete(customerFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }
}
