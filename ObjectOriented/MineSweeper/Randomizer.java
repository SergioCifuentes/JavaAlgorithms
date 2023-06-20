package MineSweeper;

public class Randomizer {
    private int size;
    private int mine;
    
    public Randomizer(int size, int mine) {
        this.size = size;
        this.mine = mine;
    }

    public Board randomizeBoard(Board board,int[] first){
        int minesPlanted=0;
        while(minesPlanted<mine){
            int col=(int)(Math.random()*size);
            int row=(int)(Math.random()*size);
            if(isAround(col, row, first)) continue;
            Space space=board.getSpace(col, row);
            if(space.isBomb()) continue;
            space.setIsBomb(true);
            System.out.println("Plant " +col+"-"+row);
            addBombsArround(board, col, row);
            minesPlanted++;

        }
        return board;
    }
    public boolean isAround(int col,int row, int[] first){
        if (col>= first[0]-1 && col<= first[0]+1 && row>=first[1]-1 && row<= first[1]+1) {
            return true;
        }
        return false;
    }

    public void addBombsArround(Board board,int col,int row){
        Dimension dim = new Dimension(col, row, size);
        for (int i = dim.getColStart(); i <= dim.getColEnd(); i++) {
            for (int j = dim.getRowStart(); j <= dim.getRowEnd(); j++) {
                board.getSpace(i, j).addBombsArround();
            }
        }
    }

}
