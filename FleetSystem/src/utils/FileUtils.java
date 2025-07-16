package src.utils; 

import src.models.Vehicle;  
import src.models.Driver;  
import src.models.Delivery; 
import src.models.Maintenance;


import java.io.*;
import java.util.*;


public class FileUtils {

    // Method to load vehicles from the vehicles.txt file
    public static List<Vehicle> loadVehicles(String filename) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String registrationNumber = parts[0];
                String type = parts[1];
                double mileage = Double.parseDouble(parts[2]);
                double fuelUsage = Double.parseDouble(parts[3]);
                vehicles.add(new Vehicle(registrationNumber, type, mileage, fuelUsage));
            }
        } catch (IOException e) {
            System.out.println("Error reading vehicle data: " + e.getMessage());
        }
        return vehicles;
    }

    // Method to save vehicles to the vehicles.txt file
    public static void saveVehicles(String filename, List<Vehicle> vehicles) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Vehicle vehicle : vehicles) {
                bw.write(vehicle.getRegistrationNumber() + "," + vehicle.getType() + "," + vehicle.getMileage() + "," + vehicle.getFuelUsage());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing vehicle data: " + e.getMessage());
        }
    }

    // Method to load drivers from the drivers.txt file
    public static List<Driver> loadDrivers(String filename) {
        List<Driver> drivers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String driverID = parts[0];
                String name = parts[1];
                String experienceLevel = parts[2];
                drivers.add(new Driver(driverID, name, experienceLevel));
            }
        } catch (IOException e) {
            System.out.println("Error reading driver data: " + e.getMessage());
        }
        return drivers;
    }

    // Method to save drivers to the drivers.txt file
    public static void saveDrivers(String filename, List<Driver> drivers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Driver driver : drivers) {
                bw.write(driver.getDriverID() + "," + driver.getName() + "," + driver.getExperienceLevel());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing driver data: " + e.getMessage());
        }
    }

    // Method to load deliveries from the deliveries.txt file
    public static List<Delivery> loadDeliveries(String filename) {
        List<Delivery> deliveries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String packageID = parts[0];
                String origin = parts[1];
                String destination = parts[2];
                String assignedVehicle = parts[3];
                String assignedDriver = parts[4];
                String ETA = parts[5];
                deliveries.add(new Delivery(packageID, origin, destination, assignedVehicle, assignedDriver, ETA));
            }
        } catch (IOException e) {
            System.out.println("Error reading delivery data: " + e.getMessage());
        }
        return deliveries;
    }

    // Method to save deliveries to the deliveries.txt file
    public static void saveDeliveries(String filename, List<Delivery> deliveries) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Delivery delivery : deliveries) {
                bw.write(delivery.getPackageID() + "," + delivery.getOrigin() + "," + delivery.getDestination() + "," + delivery.getAssignedVehicle() + "," + delivery.getAssignedDriver() + "," + delivery.getETA());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing delivery data: " + e.getMessage());
        }
    }

    // Method to load maintenance records from the maintenance.txt file
    public static List<Maintenance> loadMaintenance(String filename) {
        List<Maintenance> maintenanceRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String vehicleID = parts[0];
                String maintenanceDate = parts[1];
                String partsReplaced = parts[2];
                double cost = Double.parseDouble(parts[3]);
                maintenanceRecords.add(new Maintenance(vehicleID, maintenanceDate, partsReplaced, cost));
            }
        } catch (IOException e) {
            System.out.println("Error reading maintenance data: " + e.getMessage());
        }
        return maintenanceRecords;
    }

    // Method to save maintenance records to the maintenance.txt file
    public static void saveMaintenance(String filename, List<Maintenance> maintenanceRecords) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Maintenance maintenance : maintenanceRecords) {
                bw.write(maintenance.getVehicleID() + "," + maintenance.getMaintenanceDate() + "," + maintenance.getPartsReplaced() + "," + maintenance.getCost());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing maintenance data: " + e.getMessage());
        }
    }
}