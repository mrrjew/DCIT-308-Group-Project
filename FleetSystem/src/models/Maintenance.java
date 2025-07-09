package src.models;

public class Maintenance implements Comparable<Maintenance> {
    private String vehicleID;
    private String maintenanceDate;
    private String partsReplaced;
    private double cost;

    // Constructor
    public Maintenance(String vehicleID, String maintenanceDate, String partsReplaced, double cost) {
        this.vehicleID = vehicleID;
        this.maintenanceDate = maintenanceDate;
        this.partsReplaced = partsReplaced;
        this.cost = cost;
    }

    @Override
    public int compareTo(Maintenance other) {
        return Double.compare(this.cost, other.cost);  // Compare by cost, or any other criteria
    }

    // Getters, setters, toString, etc.
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getPartsReplaced() {
        return partsReplaced;
    }

    public void setPartsReplaced(String partsReplaced) {
        this.partsReplaced = partsReplaced;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Maintenance [VehicleID: " + vehicleID + ", Date: " + maintenanceDate + ", Parts: " + partsReplaced + ", Cost: " + cost + "]";
    }
}
