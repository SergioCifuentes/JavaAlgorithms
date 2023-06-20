package ParkingLot;

import java.time.LocalDateTime;
import java.util.Queue;
import java.util.Set;

public class LotOrganizer {
    private Set<ParkingSpot> spots;
    private Queue<Car> cars;
    private Set<ParkAssingment> parkAssingments;

    public void parkCar(Car car){
        ParkingSpot available=getAvailableParkingSpot();
        if(cars.isEmpty()&&available!=null){
            parkAssingments.add(new ParkAssingment(available, car, 
                LocalDateTime.now()));
        }else{
            addCarToQueue(car);
        }
    }

    public ParkingSpot getAvailableParkingSpot(){
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }
    public void addCarToQueue(Car car){
        cars.add(car);
    }
    public boolean assignParkingSpot(ParkingSpot spot){
        if(cars.isEmpty()) return false;
        parkAssingments.add(new ParkAssingment(spot, cars.remove(),
             LocalDateTime.now()));
        return true;
    }
}
