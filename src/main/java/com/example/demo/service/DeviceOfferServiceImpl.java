package com.example.demo.service;

import com.example.demo.dto.DeviceDto;
import com.example.demo.dto.OfferDto;
import com.example.demo.model.Device;
import com.example.demo.model.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceOfferServiceImpl implements DeviceOfferService {

    @Autowired
    DeviceService deviceService;

    @Autowired
    OfferService offerService;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void addDeviceToOffer(Long offerId, DeviceDto deviceDto) {
        Offer offer = convertOfferToEntity(offerService.getOffer(offerId));
        offer.addDevice((convertDeviceToEntity(deviceDto)));
        offerService.createOffer(convertOfferToDto(offer));
    }

    @Override
    public void addOfferToDevice(Long deviceId, OfferDto offerDto) {
        Device device = convertDeviceToEntity(deviceService.getDevice(deviceId));
        device.getOffers().add(convertOfferToEntity(offerDto));
        deviceService.createDevice(convertDeviceToDto(device));
    }

    @Override
    public List<DeviceDto> getDevicesFromOffer(Long offerId) {
        Offer offer = convertOfferToEntity(offerService.getOffer(offerId));
        return offer.getDevices()
                .stream()
                .map(this::convertDeviceToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferDto> getOffersFromDevice(Long deviceId) {
        Device device = convertDeviceToEntity(deviceService.getDevice(deviceId));
        return device.getOffers()
                .stream()
                .map(this::convertOfferToDto)
                .collect(Collectors.toList());

    }

    private DeviceDto convertDeviceToDto(Device device) {
        return modelMapper.map(device, DeviceDto.class);
    }

    private Device convertDeviceToEntity(DeviceDto deviceDto) {
        return modelMapper.map(deviceDto, Device.class);
    }

    private OfferDto convertOfferToDto(Offer offer) {
        return modelMapper.map(offer, OfferDto.class);
    }

    private Offer convertOfferToEntity(OfferDto offerDto) {
        return modelMapper.map(offerDto, Offer.class);
    }
}
