package Poison;

import java.util.ArrayList;

public class Poison {
    public static void main(String[] args) {
        
    }

    public static int findPoisonedBottle(ArrayList<Bottle> bottles,
        ArrayList<TestStrip> strips){
        runTest(bottles, strips);
        ArrayList<Integer> positives= getPositiveOnDay(strips, 7);
        return setBits(positives) ;
    }
    static void runTest(ArrayList<Bottle> bottles,ArrayList<TestStrip> testStrips){
        for (Bottle b : bottles) {
            int id =b.getId();
            int bitIndex=0;
            while (id>0) {
                if((id&1)==1){
                    testStrips.get(bitIndex).addDropOnDay(0, b);
                }
                bitIndex++;
                id>>=1;
            }
        }
    }
    static ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips,
        int day){
            ArrayList<Integer> positves= new ArrayList<Integer>();
            for (TestStrip testStrip : testStrips) {
                int id = testStrip.getId();
                if(testStrip.isPositiveOnDay(day)){
                    positves.add(id);
                }
            }
            return positves;
    }
    static int setBits(ArrayList<Integer> positives){
        int id =0;
        for (Integer integer : positives) {
            id|=1<<integer;
        }
        return id;

    }


}
