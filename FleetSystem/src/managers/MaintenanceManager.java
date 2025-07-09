package src.managers;

import src.models.Maintenance;
import src.utils.PriorityQueue;
import src.utils.FileUtils;
import java.util.List;

public class MaintenanceManager {
    private PriorityQueue<Maintenance> maintenanceQueue;
    private List<Maintenance> maintenanceRecords;

    public MaintenanceManager() {
        this.maintenanceQueue = new PriorityQueue<>();
        this.maintenanceRecords = FileUtils.loadMaintenance("../data/maintenance.txt");
        for (Maintenance maintenance : maintenanceRecords) {
            maintenanceQueue.enqueue(maintenance);
        }
    }

    // Add a maintenance record for a vehicle
    public void addMaintenance(Maintenance maintenance) {
        maintenanceQueue.enqueue(maintenance);
        maintenanceRecords.add(maintenance);
        FileUtils.saveMaintenance("../data/maintenance.txt", maintenanceRecords);  // Save to file
        System.out.println("Maintenance scheduled: " + maintenance);
    }

    // Perform maintenance on the highest priority vehicle
    public void performMaintenance() {
        Maintenance maintenance = maintenanceQueue.dequeue();
        if (maintenance != null) {
            maintenanceRecords.remove(maintenance);
            FileUtils.saveMaintenance("../data/maintenance.txt", maintenanceRecords);  // Save to file
            System.out.println("Performing maintenance: " + maintenance);
        } else {
            System.out.println("No vehicles in need of maintenance.");
        }
    }

    // Display all maintenance records
    public void displayMaintenance() {
        System.out.println("Maintenance schedule:");
        for (Maintenance maintenance : maintenanceRecords) {
            System.out.println(maintenance);
        }
    }
}
