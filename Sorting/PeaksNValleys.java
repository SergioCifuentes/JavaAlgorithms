import java.util.Arrays;

public class PeaksNValleys {
    static PeaksNValleys instance; 
    public static void main(String[] args) {
        instance=new PeaksNValleys();
        int[] array={5,3,1,2,3};
        System.out.println(Arrays.toString(array));
        instance.sort(array);
        System.out.println(Arrays.toString(array));
        
    }
    public void sort(int[] array){
        for (int i = 0; i < array.length; i+=2) {
            if(i+2<=array.length) swapEnds(array, i);
        }

        
    }
    public void swapEnds(int[] array, int start){
        int max= start;
        int min= start;
        for (int i = start+1; i < array.length; i++) {
            if(array[i]>array[max]) max=i;
            else if(array[i]<array[min]) min = i;
        }
        int swapAux=array[start];
        array[start]=array[max];
        array[max]= swapAux;

        swapAux=array[start+1];
        array[start+1]=array[min];
        array[min]= swapAux;
    }
    
}
