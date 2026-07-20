package com.example.bmc_parking_application.service;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bmc_parking_application.entity.ParkingSlot;
import com.example.bmc_parking_application.entity.ParkingTransaction;
import com.example.bmc_parking_application.entity.Vehicle;
import com.example.bmc_parking_application.enums.SlotStatus;
import com.example.bmc_parking_application.enums.TransactionStatus;
import com.example.bmc_parking_application.repository.ParkingSlotRepository;
import com.example.bmc_parking_application.repository.ParkingTransactionRepository;
import com.example.bmc_parking_application.repository.VehicleRepository;


@Service
public class ParkingService {


    private final ParkingSlotRepository parkingSlotRepository;

    private final VehicleRepository vehicleRepository;

    private final ParkingTransactionRepository transactionRepository;



    public ParkingService(
            ParkingSlotRepository parkingSlotRepository,
            VehicleRepository vehicleRepository,
            ParkingTransactionRepository transactionRepository) {

        this.parkingSlotRepository = parkingSlotRepository;
        this.vehicleRepository = vehicleRepository;
        this.transactionRepository = transactionRepository;

    }



    // Vehicle Entry

    public ParkingTransaction vehicleEntry(Vehicle vehicle) {


        vehicleRepository.save(vehicle);


        List<ParkingSlot> availableSlots =
                parkingSlotRepository.findByStatus(SlotStatus.AVAILABLE);


        if(availableSlots.isEmpty()) {

            throw new RuntimeException("No parking slot available");

        }


        ParkingSlot slot = availableSlots.get(0);


        slot.setStatus(SlotStatus.OCCUPIED);

        parkingSlotRepository.save(slot);



        ParkingTransaction transaction = new ParkingTransaction();


        transaction.setNumberPlate(vehicle.getNumberPlate());

        transaction.setSlotNumber(slot.getSlotNumber());

        transaction.setEntryTime(LocalDateTime.now());

        transaction.setStatus(TransactionStatus.ACTIVE);



        return transactionRepository.save(transaction);

    }




    // Vehicle Exit

    public ParkingTransaction vehicleExit(String numberPlate) {


        ParkingTransaction transaction =
                transactionRepository
                .findByNumberPlateAndExitTimeIsNull(numberPlate)
                .orElseThrow(() ->
                new RuntimeException("Vehicle not found"));



        transaction.setExitTime(LocalDateTime.now());


        long hours =
        ChronoUnit.HOURS.between(
                transaction.getEntryTime(),
                transaction.getExitTime());


        if(hours == 0) {

            hours = 1;

        }


        transaction.setHours(hours);



        ParkingSlot slot =
                parkingSlotRepository.findAll()
                .stream()
                .filter(s -> s.getSlotNumber()
                .equals(transaction.getSlotNumber()))
                .findFirst()
                .get();



        double amount =
                hours * slot.getPricePerHour();



        transaction.setAmount(amount);


        transaction.setStatus(TransactionStatus.COMPLETED);



        slot.setStatus(SlotStatus.AVAILABLE);

        parkingSlotRepository.save(slot);



        return transactionRepository.save(transaction);

    }


}