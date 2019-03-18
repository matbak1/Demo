package com.example.demo.service;

import com.example.demo.dto.DeviceDto;

import java.util.List;

public interface DeviceService {

    public void createDevice(DeviceDto deviceDto);

    public DeviceDto getDevice(Long id);

    public List<DeviceDto> getDevices();
}
