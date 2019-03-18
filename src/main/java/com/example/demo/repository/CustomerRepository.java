package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.projections.CustomerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<CustomerProjection> findByFirstName(String firstName);
}
