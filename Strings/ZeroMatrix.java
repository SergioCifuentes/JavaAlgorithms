import java.util.ArrayList;

public class ZeroMatrix{
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},
                        {0,6,7,8},
                        {9,11,12,13},
                        {14,15,0,0},
                        {18,19,20,21}};
    MatrixPrinter mp = new MatrixPrinter();
    mp.printMatrix(matrix);
    System.out.println("Zero");
    mp.printMatrix(zeroMatrix(matrix));
    
    }
    public static int[][] zeroMatrix(int[][] matrix){
        int rowCount=matrix.length;
        int columnCount=matrix[0].length;
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> columns = new ArrayList<Integer>();
    
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        //Zeros to rows
        for (Integer integer : rows) {
            for (int i = 0; i < columnCount ; i++) {
                matrix[integer][i]=0;
            }
        }
        //Zero for columns
        for (Integer integer : columns) {
            for (int i = 0; i < rowCount ; i++) {
                matrix[i][integer]=0;
            }
        }

        return matrix;
    }
    
}