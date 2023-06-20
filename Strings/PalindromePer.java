import java.util.HashMap;
import java.util.Map;

public class PalindromePer {
    public static void main(String[] args) {
        String input ="Tacto Coa";
        System.out.println(isPalindromePermutacion2(input));
    }

    public static boolean isPalindromePermutacion(String word){
        Map<Character, Integer> map = new HashMap<>();
        int counter=0;
        for (Character ch : word.toCharArray()) {
            if(Character.isAlphabetic(ch)){
                counter++;
                Character lower = Character.toLowerCase(ch);
                if(map.containsKey(lower)){
                    map.put(lower, map.get(lower)+1);
                }else{
                    map.put(lower, 1);
                }   
            }
        }
        int odds=0;
        if (counter%2!=0){
            odds++;
        }
        for (Character ch : map.keySet()) {
            if(map.get(ch)%2!=0){
                odds--;
            }
        }
        return odds==0;
        
    }

    public static int toggle(int bitVector, int index){
        if(index <0) return bitVector;
        int mask = 1<<index;
        bitVector ^= mask;
        //System.out.println(Integer.toBinaryString(bitVector));
        return bitVector;
    }
    public static int createBitVector(String phrase){
        int bitvector=0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitvector= toggle(bitvector,x);
        }
        return bitvector;
    }
    public static int getCharNumber(char c){
         int a = Character.getNumericValue('a');
         int z = Character.getNumericValue('z');
         int val = Character.getNumericValue(c);
         if (a<= val && val <= z){
            return val - a;
         }
         return -1;
    }
    public static boolean isPalindromePermutacion2(String phrase){
        int bitvecto = createBitVector(phrase);
        if (phrase.replaceAll(" ","").length()%2==0){
            return bitvecto==0;
        }else if(bitvecto ==0){
            return false;
        }else{
            return (bitvecto&(bitvecto-1))==0;
        }
    }
}
