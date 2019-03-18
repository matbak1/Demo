package com.example.demo.controller;

import com.example.demo.dto.DeviceDto;
import com.example.demo.dto.OfferDto;
import com.example.demo.service.DeviceOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deviceOffer")
public class DeviceOfferController {

    @Autowired
    DeviceOfferService deviceOfferService;


    @RequestMapping(value = "/offer/{id}", method = RequestMethod.GET)
    public List<DeviceDto> getDevicesFromOffer(@PathVariable("id") Long id) {
        return deviceOfferService.getDevicesFromOffer(id);
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
    public List<OfferDto> getOffersFromDevice(@PathVariable("id") Long id) {
        return deviceOfferService.getOffersFromDevice(id);
    }


    @RequestMapping(value = "/offer/{id}", method = RequestMethod.POST)
    public void addDevieToOffer(@PathVariable("id") Long id, @RequestBody DeviceDto deviceDto) {
        deviceOfferService.addDeviceToOffer(id, deviceDto);
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.POST)
    public void addOfferToDevice(@PathVariable("id") Long id, @RequestBody OfferDto offerDto) {
        deviceOfferService.addOfferToDevice(id, offerDto);
    }


}
