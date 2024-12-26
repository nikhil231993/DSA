package leetcode.designPatterns.Problems.CarRentalSystem;

import leetcode.designPatterns.Problems.CarRentalSystem.Product.Vehicle;

import java.util.List;

public class VehicleInventoryManagement {

    List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        //filtering
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
