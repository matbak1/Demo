package com.example.demo.repository;

import com.example.demo.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    Optional<Address> findById(Long id);

    Optional<Address> findByCity(String city);

}
