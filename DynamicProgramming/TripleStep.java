public class TripleStep {
    private static TripleStep instanceOf;
    public static void main(String[] args) {
        instanceOf=new TripleStep();
        System.out.println(instanceOf.countHowManyWays(5));
        System.out.println(instanceOf.countHowManyWays2(5));
        
        
        
    }
/*                                                   (0,5)
                  (1,5)                             (2,5)                   (3,5)
          (2,5)       (3,5)   (4,5)               (3,5) (4,5) (5,5)           (4,5) (5,5)
    (3,5) (4,5) (5,5) (4,5) (5,5) (5,5)    (4,5) (5,5) (5,5)               (5,5)
 (4,5) (5,5) (5,5)     (5,5)               (5,5)
 (5,5)

*/     
    public int countHowManyWays(int steps){
        return countHowManyWays(0,steps);
    }

    public int countHowManyWays(int stepsTaken,int steps){
        System.out.print("1");
        int posible=0;
        if(stepsTaken+1==steps) return posible+1;
        posible+=countHowManyWays(stepsTaken+1,steps);
        if(stepsTaken+2==steps) return posible+1;
        posible+=countHowManyWays(stepsTaken+2,steps);
        if(stepsTaken+3==steps) return posible+1;
        posible+=countHowManyWays(stepsTaken+3,steps);
        return posible;
    }

    public int countHowManyWays2(int steps){
        return countHowManyWays2(new int[steps],0,steps);
    }

    public int countHowManyWays2(int[] cache, int stepsTaken,int steps){
        System.out.print("2");
        int posible=0;
        if(stepsTaken+1==steps) return posible+1;
        if(cache[stepsTaken+1]==0){
            cache[stepsTaken+1]=countHowManyWays2(cache,stepsTaken+1,steps);
        }
        posible+=cache[stepsTaken+1];
        if(stepsTaken+2==steps) return posible+1;
        if(cache[stepsTaken+2]==0){
            cache[stepsTaken+2]=countHowManyWays2(cache,stepsTaken+2,steps);
        }
        posible+=cache[stepsTaken+2];
        if(stepsTaken+3==steps) return posible+1;
        if(cache[stepsTaken+3]==0){
            cache[stepsTaken+3]=countHowManyWays2(cache,stepsTaken+3,steps);
        }
        posible+=cache[stepsTaken+3];
        return posible;
    }
}
