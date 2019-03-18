package com.example.demo.repository;

import com.example.demo.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {


    Optional<Device> findById(Long id);
}
