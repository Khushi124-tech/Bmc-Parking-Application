package com.example.bmc_parking_application.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bmc_parking_application.entity.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    Optional<Vehicle> findByNumberPlate(String numberPlate);


}