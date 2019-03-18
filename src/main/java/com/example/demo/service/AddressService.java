package com.example.demo.service;

import com.example.demo.dto.AddressDto;

import java.util.List;

public interface AddressService {

    public void createAddress(AddressDto addressDto);

    public AddressDto getAddress(Long id);

    public List<AddressDto> getAddresses();
}
