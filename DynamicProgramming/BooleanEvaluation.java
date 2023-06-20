import java.util.HashMap;

public class BooleanEvaluation{
    //1^0|0|1 false 2 1^(0|(0|1)) 1^((0|0)|1)
    //0&0&0&1^1|0 true 10   ((((0&0)&0)&1)^1)|0 ((((0&0)&0)&1)^(1|0))
    //(((0&(0&0))&1)^1)|0 (((0&(0&0))&1)^(1|0))

    public static void main(String[] args) {
        System.out.println(countEval("1^0|0|1", false, new HashMap<String, Integer>()));
        System.out.println(countEval("0&0&0&1^1|0", true, new HashMap<String, Integer>()));
    }

    public static int countEval(String s, boolean result,HashMap<String,Integer> map){
        if(s.length()==0)
            return 0;
        if(map.containsKey(s))
            return map.get(s);
        if (s.length()==1) 
            return convertStringtoBool(s)==result?1:0;
        int ways=0;
        for (int i = 1; i < s.length(); i+=2) {
            String leftString = s.substring(0, i);
            String rightString = s.substring(i+1, s.length());
            int leftTrue =countEval(leftString, true, map);
            int leftFalse =countEval(leftString, false, map);
            int rightTrue =countEval(rightString, true, map);
            int rightFalse =countEval(rightString, false, map);
            int total= (leftTrue+leftFalse)*(rightFalse+rightTrue);
            char c=s.charAt(i);
            int totalTrue=0;
            if (c=='^') {
                totalTrue=leftFalse*rightTrue+leftTrue*rightFalse;
            }else if (c=='|') {
                totalTrue=leftFalse*rightTrue+rightTrue*leftTrue+leftTrue*rightFalse;
            }else{
                totalTrue=leftTrue*rightTrue;
            }
            int subWays = result?totalTrue:total-totalTrue;
            ways+=subWays;


        }
        map.put(result+s, ways);
        return ways;
        
    }

    public static boolean convertStringtoBool(String s){
        return s.equals("1");
    }
}