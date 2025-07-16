package src.models;

public class Vehicle implements Comparable<Vehicle> {
    private String registrationNumber;
    private String type;
    private double mileage;
    private double fuelUsage;

    // Constructor
    public Vehicle(String registrationNumber, String type, double mileage, double fuelUsage) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.mileage = mileage;
        this.fuelUsage = fuelUsage;
    }

    @Override
    public int compareTo(Vehicle other) {
        return Double.compare(this.mileage, other.mileage);  // Compare by mileage (you can change it based on your needs)
    }

    // Getters, setters, toString, etc.
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    @Override
    public String toString() {
        return "Vehicle [Registration: " + registrationNumber + ", Type: " + type + ", Mileage: " + mileage + "]";
    }
}
