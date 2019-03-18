package com.example.demo.service;

import com.example.demo.dto.DeviceDto;
import com.example.demo.model.Device;
import com.example.demo.repository.DeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createDevice(DeviceDto deviceDto) {
        Device device = convertToEntity(deviceDto);
        deviceRepository.save(device);
    }

    @Override
    public DeviceDto getDevice(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        if (!device.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found device");
        }
        return convertToDto(device.get());

    }

    @Override
    public List<DeviceDto> getDevices() {
        List<Device> deviceList = (List<Device>) deviceRepository.findAll();
        return deviceList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DeviceDto convertToDto(Device device) {
        return modelMapper.map(device, DeviceDto.class);
    }

    private Device convertToEntity(DeviceDto deviceDto) {
        return modelMapper.map(deviceDto, Device.class);
    }
}
