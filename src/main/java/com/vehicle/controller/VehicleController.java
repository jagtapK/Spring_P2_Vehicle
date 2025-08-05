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

    // we can get all vehicle
    @GetMapping("/getAllVehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        List<Vehicle> vlist = vehicleService.getAllVehicle();
        return new ResponseEntity<>(vlist, HttpStatus.OK);
    }

    // we can get vehicle by its id
    @GetMapping("/GetById/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // it will delete vehicle by id
    @GetMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        vehicleService.DeleteById(id);
        return new ResponseEntity<>("Vehicle Deleted", HttpStatus.OK);
    }

    //It will Update Exiting Details by id
    @PutMapping("/updateVehicle/{id}")
    public ResponseEntity<Vehicle> updateById(@PathVariable int id, @RequestBody Vehicle vehicle) {
        Vehicle v = vehicleService.updateById(id, vehicle);
        return new ResponseEntity<>(v, HttpStatus.OK);
    }

    @GetMapping("/SaveAllVehicles")
    public ResponseEntity<String>getAllVehicles(List<Vehicle> vehicles){
        vehicleService.saveAllVehicle(vehicles);
        return new ResponseEntity<>("Vehicle Data saved",HttpStatus.CREATED);
    }
}
