import java.util.HashMap;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) {
        String word="street";
        String permutacion="tees";
        String nonPermutacion="treees";
        System.out.println(isPermutacion(word,permutacion));
        System.out.println(isPermutacion(word,nonPermutacion));


    }
    public static boolean isPermutacion(String father, String permutacion){
        if (father.length()!=permutacion.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        //O(n)
        for (Character ch : father.toCharArray()) {
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }
        //O(m) where m <= n
        for (Character ch : permutacion.toCharArray()) {
            if(map.containsKey(ch)){
                int value = map.get(ch)-1;
                if(value<0){
                    return false;
                }else{
                    map.put(ch, value);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
