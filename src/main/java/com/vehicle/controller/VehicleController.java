package com.vehicle.controller;

import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addData")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        System.err.println(vehicle);
        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>("vehicle data saved", HttpStatus.CREATED);
    }

    @GetMapping("/getAllVehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        List<Vehicle> vlist = vehicleService.getAllVehicle();
        return new ResponseEntity<>(vlist, HttpStatus.OK);
    }

    @GetMapping("/GetById/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        vehicleService.DeleteById(id);
        return new ResponseEntity<>("Vehicle Deleted",HttpStatus.OK);
    }
}
