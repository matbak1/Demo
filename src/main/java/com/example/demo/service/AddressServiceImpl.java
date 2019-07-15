package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;


    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createAddress(AddressDto addressDto) {
        Optional<Address> address = addressRepository.findByCity(addressDto.getCity());
        if (!address.isPresent()) {
            addressRepository.save(convertToEntity(addressDto));
        }
    }

    @Override
    public AddressDto getAddress(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if (!address.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found address");
        }
        return convertToDto(address.get());
    }

    @Override
    public List<AddressDto> getAddresses() {
        List<Address> addressList = (List<Address>) addressRepository.findAll();
        return addressList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AddressDto convertToDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    private Address convertToEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
