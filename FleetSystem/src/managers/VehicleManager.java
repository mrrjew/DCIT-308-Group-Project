package src.managers;

import src.models.Vehicle;
import src.utils.SortingUtils;
import src.utils.FileUtils;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = FileUtils.loadVehicles("../data/vehicles.txt");
    }

    // Method to add a vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        FileUtils.saveVehicles("../data/vehicles.txt", vehicles); // Save to file
        System.out.println("Vehicle added: " + vehicle);
    }

    // Method to remove a vehicle by registration number
    public void removeVehicle(String registrationNumber) {
        Vehicle vehicle = searchVehicle(registrationNumber);
        if (vehicle != null) {
            vehicles.remove(vehicle);
            FileUtils.saveVehicles("../data/vehicles.txt", vehicles); // Save to file
            System.out.println("Vehicle removed: " + vehicle);
        } else {
            System.out.println("Vehicle not found: " + registrationNumber);
        }
    }

    // Method to search for a vehicle by registration number
    public Vehicle searchVehicle(String registrationNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                return vehicle;
            }
        }
        return null;  // Vehicle not found
    }

    // Method to display all vehicles
    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Sort vehicles by mileage using SortingUtils
    public void sortVehiclesByMileage() {
        SortingUtils.mergeSort(vehicles); // Assuming SortingUtils implements mergeSort
        System.out.println("Vehicles sorted by mileage:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Sort vehicles by fuel usage using SortingUtils
    public void sortVehiclesByFuelUsage() {
        SortingUtils.quickSort(vehicles); // Assuming SortingUtils implements quickSort
        System.out.println("Vehicles sorted by fuel usage:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
