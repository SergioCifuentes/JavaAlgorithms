import java.util.ArrayList;

public class Queens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];

        ArrayList<boolean[][]> boards = getPossibleWays(0, board);
        System.out.println("Boards: " + boards.size());
        for (boolean[][] bs : boards) {
            printBoard(bs);
            System.out.println("===========");
            break;
        }
    }

    public static boolean[][] clone(boolean[][] matrix) {
        boolean[][] clone = new boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            clone[i] = matrix[i].clone();
        }
        return clone;
    }
 
    public static ArrayList<boolean[][]> getPossibleWays(int row, boolean[][] board) {
        int[] possibleCol = getPosibleColumns(board[row]);
        if (possibleCol.length == 0)
            return new ArrayList<>();
        ArrayList<boolean[][]> boards = new ArrayList<boolean[][]>();
        if (row == 7) {
            board[row] = new boolean[8];
            board[row][possibleCol[0]] = true;
            boards.add(board);
        } else {
            for (int i = 0; i < possibleCol.length; i++) {
                boards.addAll(getPossibleWays(row + 1, placeQueen(clone(board), row, possibleCol[i])));
            }
        }
        return boards;
    }

    public static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "1" : "0");
            }
            System.out.println();
        }

    }

    public static boolean[][] placeQueen(boolean[][] board, int row, int col) {
        board[row] = new boolean[8];
        board[row][col] = true;
        int left = col - 1;
        int right = col + 1;
        for (int i = row + 1; i < 8; i++) {
            board[i][col] = true;
            if (left >= 0)
                board[i][left] = true;
            left--;
            if (right < 8)
                board[i][right] = true;
            right++;
        }
        return board;
    }

    public static int[] getPosibleColumns(boolean[] row) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            if (!row[i])
                list.add(i);
        }
        int[] next = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            next[i] = list.get(i);
        }
        return next;
    }
}
