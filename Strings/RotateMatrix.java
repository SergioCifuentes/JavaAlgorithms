public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},
                        {5,6,7,8},
                        {9,11,12,13},
                        {14,15,16,17},
                        {18,19,20,21}};
        printMatrix(matrix);
        System.out.println("Rotated");
        printMatrix(rotateMatrix(matrix));
    }
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] rotateMatrix(int[][] matrix){
        int[][] rotatedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            addRow(rotatedMatrix, matrix[i], i);
        }
        return rotatedMatrix;
    }
    public static void addRow(int[][] rotatedMatrix, int[] row, int index){
        for (int i = 0; i < row.length; i++) {
            rotatedMatrix[i][rotatedMatrix[0].length-index-1]=row[i];
        }
    }
}
