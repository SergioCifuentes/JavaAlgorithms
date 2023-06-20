import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] array={"race","mouse","part","pair","rapt","house","air","care"};
        System.out.println(Arrays.toString(array));
        groupAnagrams(array);
        System.out.println(Arrays.toString(array));
    }

    public static void groupAnagrams(String[] array){
        String first;
        int found=0;
        for (int i = 0; i < array.length; i+=found+1) {
            first=array[i];
            found=0;
            for (int j = i+1; j < array.length; j++) {
                if (isAnagram(first, array[j])) {
                    swap(array, i+1+found, j);
                    found++;
                }
            }
        }
    }

    public static void swap(String[] array,int i,int j){
        String aux = array[i];
        array[i]=array[j];
        array[j]=aux;
    }
    public static boolean isAnagram(String a, String b){
        if(a.length()!=b.length())return false;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (char ch : a.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, 1+map.get(ch));
            }else{
                map.put(ch, 1);
            }
            
        }
        for (char ch : b.toCharArray()) {
            if(map.containsKey(ch)){
                int value = map.get(ch)-1;
                if (value<0) return false;
                map.put(ch, value);
            }else{
                return false;
            }
        }
        return true;
    }
}
