public class EggDrop {
    static int breakingPoint=50;
    public static void main(String[] args) {
        
        

    }
    static boolean drop(int floor,Integer countDrops){
        countDrops++;
        return floor<=breakingPoint;
    }
    static int findBreakingPoint(int floors){
        Integer countDrops=0;
        int interval=14;
        int previousFloor=0;
        int egg1=interval;

        while(!drop(egg1, countDrops)&&egg1<=floors){
            interval-=1;
            previousFloor=egg1;
            egg1+=interval;
        }

        int egg2=previousFloor+1;
        while(egg2<egg1 && egg2<=floors && !drop(egg2, countDrops)){
            egg2+=1;
        }
        return egg2>floors?-1:egg2;
    }
    
}
