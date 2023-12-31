import java.util.Arrays;

public class MergeSort{
    public static MergeSort instance=new MergeSort();
    public void mergesort(int[] array){
        int[] helper=new int[array.length];
        mergesort(array, helper, 0, array.length-1);

    }
    public void mergesort(int[] array,int[] helper,int low,int high){
        if(low<high){
            int middle= (high+low)/2;
            mergesort(array,helper,low,middle);
            mergesort(array,helper,middle+1,high);
            merge(array,helper,low,middle,high);
        }
    }
//145 289

    public void merge(int[] array,int[] helper,int low,int middle,int high){
        for (int i = low; i <= high; i++) {
            helper[i]=array[i];
        }
        int helperLeft=low;
        int helperRight=middle+1;
        int current =low;
        while (helperLeft<=middle &&helperRight<=high) {
            if(helper[helperLeft]<=helper[helperRight]){
                array[current]=helper[helperLeft];
                helperLeft++;
            }else{
                array[current]=helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining=middle-helperLeft;
        for (int i = 0; i < remaining; i++) {
            array[current+i]=helper[helperLeft+i];
        }
    }

    
    
    public static void main(String[] args) {
        int[] array={1,4,5,2,8,9};
        instance.mergesort(array);
        System.out.println(Arrays.toString(array));
    }

}