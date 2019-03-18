package com.example.demo.service;


import com.example.demo.dto.OfferDto;

import java.util.List;

public interface OfferService {

    void createOffer(OfferDto offerDto);

    OfferDto getOffer(Long id);

    List<OfferDto> getOffers();

}
