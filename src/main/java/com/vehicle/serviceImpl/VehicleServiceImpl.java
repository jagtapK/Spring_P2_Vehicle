package com.vehicle.serviceImpl;

import com.vehicle.entity.Vehicle;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public String saveVehicle(Vehicle vehicle) {

        Vehicle savevehicle = vehicleRepository.save(vehicle);
        return "Vehicle saved";
    }

    @Override
    public List<Vehicle> getAllVehicle() {

        List<Vehicle> VehiclesList = vehicleRepository.findAll();
        return VehiclesList;
    }

    @Override
    public Vehicle getVehicleById(int id) {

            Vehicle vehicleById = vehicleRepository.findById(id).orElseThrow(()
                    ->new NullPointerException("Vehicle id is not found" + id));
            return vehicleById;
    }
}
