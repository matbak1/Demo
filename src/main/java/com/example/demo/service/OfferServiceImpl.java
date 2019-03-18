package com.example.demo.service;

import com.example.demo.dto.OfferDto;
import com.example.demo.model.Offer;
import com.example.demo.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createOffer(OfferDto offerDto) {
        Offer offer = convertToEntity(offerDto);
        offerRepository.save(offer);
    }

    @Override
    public OfferDto getOffer(Long id) {
        Optional<Offer> offer = offerRepository.findById(id);
        if (!offer.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found offer");
        }
        return convertToDto(offer.get());
    }

    @Override
    public List<OfferDto> getOffers() {
        List<Offer> offerList = (List<Offer>) offerRepository.findAll();
        return offerList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private OfferDto convertToDto(Offer offer) {
        return modelMapper.map(offer, OfferDto.class);
    }

    private Offer convertToEntity(OfferDto offerDto) {
        return modelMapper.map(offerDto, Offer.class);
    }
}
