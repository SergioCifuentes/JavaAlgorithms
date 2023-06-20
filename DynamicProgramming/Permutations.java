import java.util.ArrayList;
import java.util.HashMap;

public class Permutations {
    public static void main(String[] args) {
        String st = "bab";
        System.out.println(getPermutationsDup(st, "",new HashMap<String,Integer>()).toString());
    }

    public static ArrayList<String> getPermutations(String string, String current) {
        ArrayList<String> perms = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            String perm = current + ch;
            String aux = string.replace(String.valueOf(ch), "");
            if (!aux.isEmpty()) {

                perms.addAll(getPermutations(aux, perm));
            } else {

                perms.add(perm);
            }

        }
        return perms;

    }

    public static ArrayList<String> getPermutationsDup(String string, String current, HashMap<String, Integer> map) {
        ArrayList<String> perms = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            String perm = current + ch;
            if (!map.containsKey(perm)) {
                map.put(perm, 1);
                String aux = string.replaceFirst(String.valueOf(ch), "");
                if (!aux.isEmpty()) {

                    perms.addAll(getPermutationsDup(aux, perm,map));
                } else {

                    perms.add(perm);
                }
            }

        }
        return perms;

    }

    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1); // remove the first character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}