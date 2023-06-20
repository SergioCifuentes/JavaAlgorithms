package FileDuplicates;

import Othello.AssortedMethods;

public class Duplicates {
    public static final int N=32000;
    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(30, 1, 30);
		System.out.println(AssortedMethods.arrayToString(array));
		checkDuplicates(array);
    }

    public static void checkDuplicates(int[] array){
        BitSet bitSet = new BitSet(N);
        for (int i : array) {
            if (bitSet.get(i-1)) {
                System.out.println(i);
            }else{
                bitSet.set(i-1);
            }
            
        }

    }
}
