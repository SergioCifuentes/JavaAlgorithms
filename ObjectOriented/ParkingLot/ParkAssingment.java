package ParkingLot;

import java.time.LocalDateTime;

public class ParkAssingment {
    private ParkingSpot spot;
    private Car car;
    private LocalDateTime time;

    public ParkAssingment(ParkingSpot spot, Car car, LocalDateTime time) {
        this.spot = spot;
        this.car = car;
        this.time = time;
        spot.setCurParkAssingment(this);
    }

    public void registerCarLeave(){
        spot.setCurParkAssingment(null);
    }
    
    public ParkingSpot getSpot() {
        return spot;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean hasExcidedTime(LocalDateTime timeNow){
        return false;
    }

    
}
