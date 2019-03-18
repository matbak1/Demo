package com.example.demo.repository;

import com.example.demo.model.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {


    Optional<Offer> findById(Long id);
}
