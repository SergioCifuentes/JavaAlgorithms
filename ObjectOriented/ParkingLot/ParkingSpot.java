package ParkingLot;

public class ParkingSpot {
    private int id;
    private ParkAssingment curParkAssingment;
    public ParkingSpot(int id) {
        this.id = id;
    }
    public ParkAssingment getCurParkAssingment() {
        return curParkAssingment;
    }
    public void setCurParkAssingment(ParkAssingment curParkAssingment) {
        this.curParkAssingment = curParkAssingment;
    }
    public boolean isAvailable(){
        return curParkAssingment==null;
    }
}
