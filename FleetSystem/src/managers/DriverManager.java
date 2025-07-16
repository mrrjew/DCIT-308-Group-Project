package src.managers;

import src.models.Driver;
import src.utils.Queue;
import src.utils.FileUtils;
import java.util.List;

public class DriverManager {
    private Queue<Driver> availableDrivers;
    private List<Driver> drivers;

    public DriverManager() {
        this.availableDrivers = new Queue<>();
        this.drivers = FileUtils.loadDrivers("../data/drivers.txt"); 
        for (Driver driver : drivers) {
            availableDrivers.enqueue(driver);
        }
    }

    public void addDriver(Driver driver) {
        availableDrivers.enqueue(driver);
        drivers.add(driver);
        FileUtils.saveDrivers("../data/drivers.txt", drivers); 
        System.out.println("Driver added: " + driver);
    }

    public Driver assignDriver() {
        Driver driver = availableDrivers.dequeue();
        if (driver != null) {
            System.out.println("Driver assigned: " + driver);
        } else {
            System.out.println("No available drivers.");
        }
        return driver;
    }

    public void displayAvailableDrivers() {
        // logic to print available drivers
    }
}
