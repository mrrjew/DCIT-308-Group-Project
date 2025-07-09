package src.models;

public class Driver {
    private String driverID;
    private String name;
    private String experienceLevel;
    private String assignedVehicle;

    // Constructor
    public Driver(String driverID, String name, String experienceLevel) {
        this.driverID = driverID;
        this.name = name;
        this.experienceLevel = experienceLevel;
        this.assignedVehicle = "";
    }

    // Getters and setters
    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(String assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    @Override
    public String toString() {
        return "Driver [ID: " + driverID + ", Name: " + name + ", Experience: " + experienceLevel + "]";
    }
}
