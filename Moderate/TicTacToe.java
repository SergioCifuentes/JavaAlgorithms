public class TicTacToe {
    public static final int P1=1;
    public static final int P2=2;
    public static final int BL=0;
    public static void main(String[] args) {
        int[][] board ={{P1,BL,P2},
                        {P2,P1,P1},
                        {BL,P2,P2}};

        System.out.println(hasWon(board));
                       

    }

    public static boolean hasWon(int[][] board){
        //Check Rows
        for (int i = 0; i < board.length; i++) {
            if (checkRow(board[i])) {
                return true;
            }
        }
        //Check Columns
        for (int i = 0; i < board[0].length; i++) {
            if (checkColumn(board,i)) {
                return true;
            }
        }
        //Check Diagonals
        return checkDiagonals(board);
    }

    private static boolean checkDiagonals(int[][] board){
        if (board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!=BL) {
            return true;
        }
        if (board[2][0]==board[1][1]&&board[1][1]==board[0][2]&&board[2][0]!=BL) {
            return true;
        }

        return false;
    }

    private static boolean checkColumn(int[][] board, int column){
        int aux=0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column]==BL) return false;
            if(i==0) aux=board[i][column];
            if(board[i][column]!= aux) return false;
        }
        return true;
    }
    private static boolean checkRow(int[] row){
        int aux=0;
        for (int i = 0; i < row.length; i++) {
            if (row[i]==BL) return false;
            if(i==0) aux=row[i];
            if(row[i]!= aux) return false;
        }
        return true;
    }

enum Piece {Empty, Red, Blue};

int convertBoardToInt(Piece[][] board){
    int sum=0;
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            int value= board[i][j].ordinal();
            sum=sum*3+value;
        }
        
    }
    return sum;
}
}
