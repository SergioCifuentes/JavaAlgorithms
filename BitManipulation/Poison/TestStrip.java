package Poison;
import java.util.ArrayList;

public class TestStrip {
    public static int DAY_FOR_RESULT=7;
    private ArrayList<ArrayList<Bottle>> dropsByDay=
        new ArrayList<ArrayList<Bottle>>();
    private int id;
    public TestStrip(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void sizeDropsForDay(int day){
        while (dropsByDay.size()<=day) {
            dropsByDay.add(new ArrayList<>());
        }
    }
    public void addDropOnDay(int day,Bottle bottle){
        sizeDropsForDay(day);
        ArrayList<Bottle> drops=dropsByDay.get(day);
        drops.add(bottle);
    }
    private boolean hasPoison(ArrayList<Bottle> bottles){
        for (Bottle bottle : bottles) {
            if (bottle.isPoisoned()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Bottle> getLastWeeksBottles(int day){
        if(day<DAY_FOR_RESULT){
            return null;
        }
        return dropsByDay.get(day-DAY_FOR_RESULT);
    }
    public boolean isPositiveOnDay(int day){
        int testDay = day - DAY_FOR_RESULT;
        if(testDay<0||testDay>=dropsByDay.size()){
            return false;
        }
        for (int i = 0; i < testDay; i++) {
            ArrayList<Bottle> bottles = dropsByDay.get(i);
            if(hasPoison(bottles)){
                return true;
            }
        }
        return false;
    }
}
