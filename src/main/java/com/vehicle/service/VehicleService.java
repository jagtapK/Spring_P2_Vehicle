package com.vehicle.service;

import com.vehicle.entity.Vehicle;

import java.util.List;

public interface VehicleService {

public String saveVehicle(Vehicle vehicle);

public List<Vehicle> getAllVehicle();

public Vehicle getVehicleById(int id);
}
