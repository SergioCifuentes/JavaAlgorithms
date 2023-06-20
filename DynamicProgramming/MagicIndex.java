public class MagicIndex {
    public static void main(String[] args) {
        //            0   1   2 3 4 5 6 7 8 9 10 
        int[] array={-40,-20,-1,1,2,3,5,7,9,12,13};
        //            0   1  2 3 4 5 6 7 8 9 10 
        int[] array2={-10,-5,2,2,2,3,4,5,9,12,13};
        System.out.println(findMagicIndexNotDistinct(array, 0, array.length-1));
        System.out.println(findMagicIndexNotDistinct(array2, 0, array.length-1));

    }

    public static int  findMagicIndexDistinct(int[] array,int low, int high){
        
        if(high<low)return -1;
        int mid=(high+low)/2;
        if(array[mid]==mid) return mid;
        else if(array[mid]>mid){
            return findMagicIndexDistinct(array, low, mid-1);
        }else{
            return findMagicIndexDistinct(array, mid+1, high);
        }
    }

    public static int  findMagicIndexNotDistinct(int[] array,int low, int high){
        
        if(high<low)return -1;
        int mid=(high+low)/2;
        int left=-1;
        int right=-1;
        if(array[mid]==mid) return mid;
        else if(array[mid]>mid){
            if(array[mid]<array.length-1){
                right=findMagicIndexNotDistinct(array, array[mid], high);
                if(right!=-1) return right;
            }
            left=findMagicIndexNotDistinct(array, low, mid-1);
            return left;
        }else{
            if(array[mid]>=0){
                left=findMagicIndexNotDistinct(array, low, array[mid]);
                if(left!=-1) return left;
            }
            right=findMagicIndexNotDistinct(array, mid+1,high);
            return right;
        }

    }

}
