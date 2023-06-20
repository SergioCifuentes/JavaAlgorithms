package MineSweeper;

import java.util.Scanner;


public class Game {
    public static final int SIZE=10;
    public static final int MINES=10;
    private Board board;
    

    public void startGame(){
        board=new Board(SIZE,MINES);
        board.printBoard();
        int[] first = requestInput();
        Randomizer randomize= new Randomizer(SIZE, MINES);
        randomize.randomizeBoard(board,first);
        System.out.println("Random");
        Boolean safe=board.selectSpace(first);

        while(safe&&!board.verifyWin()){
            board.printBoard();
            int[] pick = requestInput();
            safe=board.selectSpace(pick);
        }

        board.printBoard();
        if (!safe) {
            loseGame();
        }else{
            winGame(); 
        }

    }
    public void loseGame(){
        System.out.println("YOU LOSE, GAME OVER");
    }
    public void winGame(){
        System.out.println("Congrats YOU WON");
    }



    public int[] requestInput(){
        int[] coordinates=new int[2];
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter next coordinate (Column Row)");
        String input = scan.nextLine();
        String[] split =input.split(" ");
        coordinates[0]=Integer.valueOf(split[0]);
        coordinates[1]=Integer.valueOf(split[1]);
        return coordinates;
        
    }

}
