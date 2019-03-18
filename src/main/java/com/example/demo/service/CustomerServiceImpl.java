package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.projections.CustomerProjection;
import com.example.demo.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void createCustomer(CustomerDto customerDto) {
        customerRepository.save(convertToEntity(customerDto));
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found customer");
        }
        return convertToDto(customer.get());
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getCustomers(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        Page<CustomerDto> customerDtoPage = customerPage.map(this::convertToDto);
        return new ResponseEntity<>(customerDtoPage.getContent(), HttpStatus.OK);
    }

    @Override
    public void updateCustomer(String firstName, String lastName, CustomerDto customerDto) {
        Optional<Customer> customer = customerRepository.findByFirstNameAndLastName(firstName,lastName);
        Customer customer1 = convertToEntity(customerDto);
        if (customer.isPresent()){
            customer.get().setFirstName(customer1.getFirstName());
            customer.get().setLastName(customer1.getLastName());
            customer.get().setAddress(customer1.getAddress());
            createCustomer(convertToDto(customer.get()));
        } else {
            createCustomer(customerDto);
        }


    }

    @Override
    public CustomerDto findCustomerByFirstNameAndLastName(String firstName, String lastName) {
        Optional<Customer> customer = customerRepository.findByFirstNameAndLastName(firstName, lastName);
        if (!customer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found customer: " + firstName + " " + lastName);
        }

        return convertToDto(customer.get());
    }

    @Override
    public void createCustomerAddress(Long id, AddressDto addressDto) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer customer1 = customer.get();
            customer1.setAddress(convertAddressToEntity(addressDto));
            customerRepository.save(customer1);
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(customer1 -> customerRepository.delete(customer1));
    }

    @Override
    public CustomerProjection getCustomerByFirstName(String firstName) {
        Optional<CustomerProjection> customer = customerRepository.findByFirstName(firstName);
        return customer.get();
    }

    @Override
    public Long getCustomerCount() {
        return customerRepository.count();
    }


    private CustomerDto convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    private Customer convertToEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    private Address convertAddressToEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }

}
