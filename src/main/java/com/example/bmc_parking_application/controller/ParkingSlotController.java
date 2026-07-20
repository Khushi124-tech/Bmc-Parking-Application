package com.example.bmc_parking_application.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.bmc_parking_application.entity.ParkingSlot;
import com.example.bmc_parking_application.service.ParkingSlotService;



@RestController
@RequestMapping("/api/slots")
public class ParkingSlotController {


    private final ParkingSlotService parkingSlotService;


    public ParkingSlotController(ParkingSlotService parkingSlotService) {

        this.parkingSlotService = parkingSlotService;

    }



    // Add parking slot

    @PostMapping
    public ParkingSlot addSlot(@RequestBody ParkingSlot slot) {

        return parkingSlotService.addSlot(slot);

    }



    // Get all slots

    @GetMapping
    public List<ParkingSlot> getAllSlots() {

        return parkingSlotService.getAllSlots();

    }



    // Get available slots

    @GetMapping("/available")
    public List<ParkingSlot> getAvailableSlots() {

        return parkingSlotService.getAvailableSlots();

    }



    // Update slot

    @PutMapping("/{id}")
    public ParkingSlot updateSlot(
            @PathVariable Long id,
            @RequestBody ParkingSlot slot) {


        return parkingSlotService.updateSlot(id, slot);

    }



    // Delete slot

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSlot(
            @PathVariable Long id) {


        parkingSlotService.deleteSlot(id);

        return ResponseEntity.ok("Slot deleted successfully");

    }

}