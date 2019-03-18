package com.example.demo.service;

import com.example.demo.dto.DeviceDto;
import com.example.demo.dto.OfferDto;

import java.util.List;

public interface DeviceOfferService {

    void addDeviceToOffer(Long offerId, DeviceDto device);

    void addOfferToDevice(Long deviceId, OfferDto offer);

    List<DeviceDto> getDevicesFromOffer(Long offerId);

    List<OfferDto> getOffersFromDevice(Long deviceId);


}
