package com.example.bmc_parking_application.entity;


import com.example.bmc_parking_application.enums.SlotStatus;
import com.example.bmc_parking_application.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "parking_slot")
public class ParkingSlot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String slotNumber;


    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;


    @Enumerated(EnumType.STRING)
    private SlotStatus status;


    private double pricePerHour;


    // Default constructor required by JPA
    public ParkingSlot() {

    }


    // Parameterized constructor
    public ParkingSlot(String slotNumber, VehicleType vehicleType,
                       SlotStatus status, double pricePerHour) {

        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.status = status;
        this.pricePerHour = pricePerHour;
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }


    public String getSlotNumber() {
        return slotNumber;
    }


    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }


    public SlotStatus getStatus() {
        return status;
    }


    public void setStatus(SlotStatus status) {
        this.status = status;
    }


    public double getPricePerHour() {
        return pricePerHour;
    }


    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

}