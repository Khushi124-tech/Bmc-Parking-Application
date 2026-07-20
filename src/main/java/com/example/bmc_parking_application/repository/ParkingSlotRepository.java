package com.example.bmc_parking_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bmc_parking_application.entity.ParkingSlot;
import com.example.bmc_parking_application.enums.SlotStatus;


public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {


    List<ParkingSlot> findByStatus(SlotStatus status);


}
