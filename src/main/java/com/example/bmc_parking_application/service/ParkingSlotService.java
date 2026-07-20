package com.example.bmc_parking_application.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bmc_parking_application.entity.ParkingSlot;
import com.example.bmc_parking_application.enums.SlotStatus;
import com.example.bmc_parking_application.repository.ParkingSlotRepository;


@Service
public class ParkingSlotService {


    private final ParkingSlotRepository parkingSlotRepository;


    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {

        this.parkingSlotRepository = parkingSlotRepository;

    }


    // Add parking slot
    public ParkingSlot addSlot(ParkingSlot slot) {

        return parkingSlotRepository.save(slot);

    }


    // Get all slots
    public List<ParkingSlot> getAllSlots() {

        return parkingSlotRepository.findAll();

    }


    // Get available slots
    public List<ParkingSlot> getAvailableSlots() {

        return parkingSlotRepository.findByStatus(SlotStatus.AVAILABLE);

    }


    // Update slot
    public ParkingSlot updateSlot(Long id, ParkingSlot updatedSlot) {


        ParkingSlot existingSlot =
                parkingSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));


        existingSlot.setSlotNumber(updatedSlot.getSlotNumber());
        existingSlot.setVehicleType(updatedSlot.getVehicleType());
        existingSlot.setStatus(updatedSlot.getStatus());
        existingSlot.setPricePerHour(updatedSlot.getPricePerHour());


        return parkingSlotRepository.save(existingSlot);

    }


    // Delete slot
    public void deleteSlot(Long id) {

        parkingSlotRepository.deleteById(id);

    }


}