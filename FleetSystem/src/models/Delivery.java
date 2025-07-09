package src.models;

public class Delivery {
    private String packageID;
    private String origin;
    private String destination;
    private String assignedVehicle;
    private String assignedDriver;
    private String ETA;

    public Delivery(String packageID, String origin, String destination, String assignedVehicle, String assignedDriver, String ETA) {
        this.packageID = packageID;
        this.origin = origin;
        this.destination = destination;
        this.assignedVehicle = assignedVehicle;
        this.assignedDriver = assignedDriver;
        this.ETA = ETA;
    }

    // Getters and setters
    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(String assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public String getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(String assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    @Override
    public String toString() {
        return "Delivery [Package ID: " + packageID + ", Origin: " + origin + ", Destination: " + destination + ", ETA: " + ETA + "]";
    }
}
