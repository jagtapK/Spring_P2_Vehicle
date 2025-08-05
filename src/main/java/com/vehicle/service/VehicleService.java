package com.vehicle.service;

import com.vehicle.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    public String saveVehicle(Vehicle vehicle);

    public List<Vehicle> getAllVehicle();

    public Vehicle getVehicleById(int id);

    public String DeleteById(int id);

    Vehicle updateById(int id, Vehicle newDetails);

    public void saveAllVehicle(List<Vehicle> vehicle);

    public String deleteById(int id);
}
