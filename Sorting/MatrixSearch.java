public class MatrixSearch {

    public static class Coor{
        int col;
        int row;
        public Coor(int row, int col) {
            this.col = col;
            this.row = row;
        }
        public String toString(){
            return "ROW: "+row+" COL "+col;
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix={{2,4,6,7},{3,5,8,9},{10,11,12,13},{14,15,16,17}};
        for (int i = 1; i <= 18; i++) {
            System.out.println(i+" "+searchMatrix(matrix, i));
        }

        
    }

    public static boolean findElement(int[][] matrix, int elem) {
		int row = 0;
		int col = matrix[0].length - 1; 
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++; 
			}
		} 
		return false; 
	}
    public static Coor searchMatrix(int[][]matrix, int value){
            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                if(row[0]> value) return null;  
                if(row[0]<=value&& row[row.length-1]>=value){
                    int binSearch= binarySearchRecursive(row, value, 0, row.length);
                    if(binSearch!=-1) return new Coor(i, binSearch);
                }
            }
            
        return null;
    }

 

    public static int binarySearchRecursive(int array[], int x,int low, int high){
        if(low>high) return -1;
        int mid = low+(high-low)/2;
        if(array[mid]<x){
            return binarySearchRecursive(array, x,mid+1,high);
        }else if(array[mid]>x){
            return binarySearchRecursive(array, x,low,mid-1);
        }else{
            return mid;
        }
    }


}
