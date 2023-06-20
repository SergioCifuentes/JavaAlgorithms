public class BinarySearch{
    public int binarySearch(int[] array, int x){
        int low=0;
        int high =array.length-1;
        int mid;
        while(low<=high){
            mid = low+(high+low)/2;
            if(array[mid]<x){
                low=mid+1;
            }else if(array[mid]>x){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return -1;

    }

    public int binarySearchRecursive(int array[], int x,int low, int high){
        if(low>high) return -1;
        int mid = low+(high+low)/2;
        if(array[mid]<x){
            return binarySearchRecursive(array, x,mid+1,high);
        }else if(array[mid]>x){
            return binarySearchRecursive(array, x,low,mid-1);
        }else{
            return mid;
        }
    }
}