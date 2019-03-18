package com.example.demo.controller;

import com.example.demo.dto.DeviceDto;
import com.example.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;


    @RequestMapping(method = RequestMethod.GET)
    public List<DeviceDto> getDevices() {
        return deviceService.getDevices();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DeviceDto getDevice(@PathVariable("id") Long id) {
        return deviceService.getDevice(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createDevice(@RequestBody DeviceDto deviceDto) {
        deviceService.createDevice(deviceDto);
    }
}
