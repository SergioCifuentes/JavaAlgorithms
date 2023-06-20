public class SparseSearch {
    public static void main(String[] args) {
        String[] array={"at","","","","ball","","","car","","","dad","",""};
        System.out.println(search(array, "at"));
        System.out.println(search(array, "ball"));
        System.out.println(search(array, "car"));
        System.out.println(search(array, "dad"));
    }
    public static int search(String[] array,String value){ 
        return search(array, value, 0, array.length-1);
    }

    public static int search(String[] array,String value,int low,int high){
        if(low>high) return -1;
        int mid = low+(high-low)/2;
        String midValue=array[mid];
        int right=mid;
        int left=mid;
        
        while (midValue=="") {
            right++;
            if (right<= high &&array[right]!="") {
                mid=right;
                break;
            }
            left--;
            if (left>= low &&array[left]!="") {
                mid=left;
                break;
            }
        }
        midValue=array[mid];
        int compare=midValue.compareTo(value);
        if (compare<0) {
            return search(array, value,right+1,high);
        }else if(compare>0){
            return search(array, value,low,left-1);
        }else{
            return mid; 
        }
    }
}
