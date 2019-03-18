package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.projections.CustomerProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CustomerService {

    void createCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(Long id);

    ResponseEntity<List<CustomerDto>> getCustomers(Pageable pageable);

    void updateCustomer(String firstName, String lastName, CustomerDto customerDto);

    CustomerDto findCustomerByFirstNameAndLastName(String firstName, String lastName);

    void createCustomerAddress(Long id, AddressDto addressDto);

    void deleteCustomer(Long id);

    CustomerProjection getCustomerByFirstName(String firstName);

    Long getCustomerCount();

}
