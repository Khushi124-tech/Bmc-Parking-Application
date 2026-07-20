package com.example.bmc_parking_application.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bmc_parking_application.entity.ParkingTransaction;


public interface ParkingTransactionRepository extends JpaRepository<ParkingTransaction, Long> {


    Optional<ParkingTransaction> findByNumberPlateAndExitTimeIsNull(String numberPlate);


}