package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.projections.CustomerProjection;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PagedResourcesAssembler pagedResourcesAssembler;

    @RequestMapping("")
    public ResponseEntity<List<CustomerDto>> getCustomers(@PageableDefault() Pageable pageable) {
        return customerService.getCustomers(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomerDto getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
    }

    @RequestMapping(value = "/{firstName}/{lastName}")
    public CustomerDto getCustomerByName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return customerService.findCustomerByFirstNameAndLastName(firstName, lastName);

    }

    @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(firstName, lastName, customerDto);
    }

    @RequestMapping(value = "/{id}/address", method = RequestMethod.POST)
    public void setCustomerAddress(@PathVariable("id") Long id, @RequestBody AddressDto addressDto) {
        customerService.createCustomerAddress(id, addressDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }


    @RequestMapping(value = "/byName/{firstName}", method = RequestMethod.GET)
    public CustomerProjection getCustomerByName(@PathVariable String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }

}
