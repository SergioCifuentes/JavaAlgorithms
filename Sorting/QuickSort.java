public class QuickSort {
    public void quickSort(int[]  array, int left, int right){
        int index=partition(array, left, right);
        if(left<index-1){//Sort left half
            quickSort(array, left, index-1);
        }
        if(index<right){//Sort right half
            quickSort(array, index, right);
        }

    }

    public int partition(int[]  array, int left, int right){
        int pivot=array[left+(right-left)/2]; //Pick pivot point
        while (left<=right) {
            //Find element on left that should be on right
            while(array[left]<pivot)left++;

            //Find element on right that should be on left
            while(array[right]<pivot)right++;

            //Swap elements, and move left and right indices
            if(left<=right){
                swap(array,left,right);
                left++;
                right--;
            }
            

        }
        return left;
    }
    public void swap(int[] array, int left, int right){
        int aux = array[left];
        array[left]=array[right];
        array[right]=aux;
    }
}
