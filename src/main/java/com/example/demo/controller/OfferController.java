package com.example.demo.controller;

import com.example.demo.dto.OfferDto;
import com.example.demo.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OfferDto getOfferById(@PathVariable("id") Long id) {
        return offerService.getOffer(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<OfferDto> getOffers() {
        return offerService.getOffers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOffer(@RequestBody OfferDto offerDto) {
        offerService.createOffer(offerDto);
    }
}
