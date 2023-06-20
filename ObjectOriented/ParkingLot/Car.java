package ParkingLot;

public class Car {
    private String plateNumber;
    private String description;
    private String Owner;
    public Car(String plateNumber, String description, String owner) {
        this.plateNumber = plateNumber;
        this.description = description;
        Owner = owner;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public String getDescription() {
        return description;
    }
    public String getOwner() {
        return Owner;
    }
    
    
}
