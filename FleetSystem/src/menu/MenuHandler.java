package menu;

import java.util.Scanner;
import src.managers.VehicleManager;
import src.managers.DriverManager;
import src.managers.DeliveryManager;
import src.managers.MaintenanceManager;
import src.models.Vehicle;
import src.models.Driver;
import src.models.Delivery;
import src.models.Maintenance;

public class MenuHandler {

    private static VehicleManager vehicleManager = new VehicleManager();
    private static DriverManager driverManager = new DriverManager();
    private static DeliveryManager deliveryManager = new DeliveryManager();
    private static MaintenanceManager maintenanceManager = new MaintenanceManager();

    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Adom Logistics Fleet System ====");
            System.out.println("1. Manage Vehicles");
            System.out.println("2. Assign Driver");
            System.out.println("3. Track Deliveries");
            System.out.println("4. Maintenance Scheduler");
            System.out.println("5. Fuel Efficiency Reports");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageVehicles(scanner);
                    break;
                case 2:
                    assignDriver(scanner);
                    break;
                case 3:
                    trackDeliveries(scanner);
                    break;
                case 4:
                    maintenanceScheduler(scanner);
                    break;
                case 5:
                    fuelEfficiencyReports();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    // Manage vehicles - add, remove, search, sort
    private static void manageVehicles(Scanner scanner) {
        System.out.println("\n==== Vehicle Management ====");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. Search Vehicle");
        System.out.println("4. Sort Vehicles by Mileage");
        System.out.println("5. Sort Vehicles by Fuel Usage");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Vehicle Registration Number: ");
                String regNum = scanner.nextLine();
                System.out.print("Enter Vehicle Type (e.g., Truck, Van): ");
                String type = scanner.nextLine();
                System.out.print("Enter Vehicle Mileage: ");
                double mileage = scanner.nextDouble();
                System.out.print("Enter Vehicle Fuel Usage: ");
                double fuelUsage = scanner.nextDouble();
                vehicleManager.addVehicle(new Vehicle(regNum, type, mileage, fuelUsage));
                break;
            case 2:
                System.out.print("Enter Vehicle Registration Number to Remove: ");
                String regToRemove = scanner.nextLine();
                vehicleManager.removeVehicle(regToRemove);
                break;
            case 3:
                System.out.print("Enter Vehicle Registration Number to Search: ");
                String regToSearch = scanner.nextLine();
                Vehicle vehicle = vehicleManager.searchVehicle(regToSearch);
                if (vehicle != null) {
                    System.out.println("Vehicle Found: " + vehicle);
                } else {
                    System.out.println("Vehicle not found.");
                }
                break;
            case 4:
                vehicleManager.sortVehiclesByMileage();
                break;
            case 5:
                vehicleManager.sortVehiclesByFuelUsage();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Assign a driver from the queue
    private static void assignDriver(Scanner scanner) {
        System.out.println("\n==== Driver Assignment ====");
        System.out.println("1. Add Driver");
        System.out.println("2. Assign Driver");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Driver ID: ");
                String driverID = scanner.nextLine();
                System.out.print("Enter Driver Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Driver Experience Level: ");
                String experienceLevel = scanner.nextLine();
                driverManager.addDriver(new Driver(driverID, name, experienceLevel));
                break;
            case 2:
                Driver driver = driverManager.assignDriver();
                if (driver != null) {
                    System.out.println("Assigned Driver: " + driver);
                } else {
                    System.out.println("No available drivers.");
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Track deliveries in the queue
    private static void trackDeliveries(Scanner scanner) {
        System.out.println("\n==== Delivery Tracking ====");
        System.out.println("1. Add Delivery");
        System.out.println("2. Complete Delivery");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Package ID: ");
                String packageID = scanner.nextLine();
                System.out.print("Enter Origin: ");
                String origin = scanner.nextLine();
                System.out.print("Enter Destination: ");
                String destination = scanner.nextLine();
                System.out.print("Enter Assigned Vehicle Registration Number: ");
                String assignedVehicle = scanner.nextLine();
                System.out.print("Enter Assigned Driver ID: ");
                String assignedDriver = scanner.nextLine();
                System.out.print("Enter ETA: ");
                String eta = scanner.nextLine();
                deliveryManager.addDelivery(new Delivery(packageID, origin, destination, assignedVehicle, assignedDriver, eta));
                break;
            case 2:
                deliveryManager.completeDelivery();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Maintenance scheduler - add and perform maintenance
    private static void maintenanceScheduler(Scanner scanner) {
        System.out.println("\n==== Maintenance Scheduler ====");
        System.out.println("1. Add Maintenance Record");
        System.out.println("2. Perform Maintenance");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Vehicle ID: ");
                String vehicleID = scanner.nextLine();
                System.out.print("Enter Maintenance Date: ");
                String maintenanceDate = scanner.nextLine();
                System.out.print("Enter Parts Replaced: ");
                String partsReplaced = scanner.nextLine();
                System.out.print("Enter Maintenance Cost: ");
                double cost = scanner.nextDouble();
                maintenanceManager.addMaintenance(new Maintenance(vehicleID, maintenanceDate, partsReplaced, cost));
                break;
            case 2:
                maintenanceManager.performMaintenance();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Placeholder for Fuel Efficiency Reports
    private static void fuelEfficiencyReports() {
        System.out.println("\n==== Fuel Efficiency Reports ====");
        // logic to calculate and display fuel efficiency reports.
        System.out.println("Generating fuel efficiency reports... (Coming soon)");
    }
}
