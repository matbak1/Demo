package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @RequestMapping(method = RequestMethod.GET)
    public List<AddressDto> getAddresses() {
        return addressService.getAddresses();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AddressDto getAddress(@PathVariable("id") Long id) {
        return addressService.getAddress(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createAddress(@RequestBody AddressDto addressDto) {
        addressService.createAddress(addressDto);
    }


}
