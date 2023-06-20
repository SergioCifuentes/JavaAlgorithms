import java.util.Scanner;

public class PaintFill {
    public static void main(String[] args) {
        int[][] screen=new int[10][15];
        screen=fillColor(screen);
        for (int i = 0; i < screen.length; i++) {
            printRow(screen[i]);
            System.out.println();
        }
        Scanner scan = new Scanner(System.in);
        int row=Integer.valueOf(scan.nextLine());
        int column=Integer.valueOf(scan.nextLine());
        scan.close();
        
        screen=fillPaint(row,column,4,screen,screen[row][column]);
        for (int i = 0; i < screen.length; i++) {
            printRow(screen[i]);
            System.out.println();
        }
    }

    public static int[][] fillPaint(int row, int col, int color,int[][]screen,int old){
        if(row>=0&&col>=0 &&row<screen.length&&col<screen[0].length){
            if(screen[row][col]==old){
            screen[row][col]=color;
            screen= fillPaint(row-1, col, color, screen, old);
            screen= fillPaint(row+1, col, color, screen, old);
            screen= fillPaint(row, col-1, color, screen, old);
            screen= fillPaint(row, col+1, color, screen, old);
            } 
        }
        return screen;
    }

    public static void printRow(int[] row){
        System.out.printf("[");
        for (int r : row) {
            System.out.printf(String.valueOf(r));
        }
        System.out.printf("]");
    }
    public static int[][] fillColor(int[][] screen){
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                screen[i][j]=(int)(Math.random()*3)+1;
            }
        }
        return screen;
    }
}
