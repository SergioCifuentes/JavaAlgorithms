import java.util.Arrays;

public class SortedMerge {
    public static void main(String[] args) {
        int[] A = new int[12];
        int[] B = { 3, 5, 7, 11 };
        for (int i = 0; i < 8; i++) {
            A[i] = i * 2;
        }
        System.out.println(Arrays.toString(A));
        merge(A, B);
        System.out.println(Arrays.toString(A));
    }

    public static void merge(int[] A, int[] B) {
        int aIndex = A.length - B.length - 1;
        int bIndex = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if(bIndex < 0) break;
            if (aIndex >= 0 &&A[aIndex] > B[bIndex]) {
                A[i] = A[aIndex];
                aIndex--;
                
            } else if (bIndex >= 0) {
                A[i] = B[bIndex];
                bIndex--;
            } 
        }

    }
}
