package com.example.bmc_parking_application.entity;


import java.time.LocalDateTime;

import com.example.bmc_parking_application.enums.TransactionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "parking_transaction")
public class ParkingTransaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String numberPlate;


    private String slotNumber;


    private LocalDateTime entryTime;


    private LocalDateTime exitTime;


    private long hours;


    private double amount;


    @Enumerated(EnumType.STRING)
    private TransactionStatus status;



    // Default constructor required by JPA
    public ParkingTransaction() {

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


    public String getSlotNumber() {
        return slotNumber;
    }


    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }


    public LocalDateTime getEntryTime() {
        return entryTime;
    }


    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }


    public LocalDateTime getExitTime() {
        return exitTime;
    }


    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }


    public long getHours() {
        return hours;
    }


    public void setHours(long hours) {
        this.hours = hours;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public TransactionStatus getStatus() {
        return status;
    }


    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

}
