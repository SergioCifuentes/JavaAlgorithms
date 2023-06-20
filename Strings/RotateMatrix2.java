public class RotateMatrix2 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},
        {5,6,7,8},
        {9,11,12,13},
        {14,15,16,17}};
        printMatrix(matrix);
        System.out.println("Rotate");
        rotate(matrix);
        printMatrix(matrix);

    }
    static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    static boolean rotate(int[][] matrix){
        if(matrix.length ==0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer ++){
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                 matrix[first][i]= matrix [last-offset][first];

                matrix[last-offset][first]= matrix [last][last-offset];
                matrix[last][last-offset]= matrix [i][last];
                matrix[i][last]= top;
                
            }
        }
        return true;
    }
}
