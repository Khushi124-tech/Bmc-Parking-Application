package com.example.bmc_parking_application.entity;


import com.example.bmc_parking_application.enums.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "vehicle")
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String numberPlate;


    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;


    private String ownerName;



    // Default constructor required by JPA
    public Vehicle() {

    }


    // Parameterized constructor
    public Vehicle(String numberPlate, VehicleType vehicleType, String ownerName) {

        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;

    }


    // Getters and Setters

    public Long getId() {
        return id;
    }


    public String getNumberPlate() {
        return numberPlate;
    }


    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }


    public String getOwnerName() {
        return ownerName;
    }


    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}