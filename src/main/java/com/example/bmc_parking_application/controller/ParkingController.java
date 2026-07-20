package com.example.bmc_parking_application.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.bmc_parking_application.entity.ParkingTransaction;
import com.example.bmc_parking_application.entity.Vehicle;
import com.example.bmc_parking_application.service.ParkingService;



@RestController
@RequestMapping("/api/parking")
public class ParkingController {



    private final ParkingService parkingService;



    public ParkingController(ParkingService parkingService) {

        this.parkingService = parkingService;

    }



    // Vehicle Entry

    @PostMapping("/entry")
    public ParkingTransaction vehicleEntry(
            @RequestBody Vehicle vehicle) {


        return parkingService.vehicleEntry(vehicle);

    }



    // Vehicle Exit

    @PostMapping("/exit")
    public ParkingTransaction vehicleExit(
            @RequestParam String numberPlate) {


        return parkingService.vehicleExit(numberPlate);

    }


}
