package MineSweeper;

public class Board {
    // Space[Col][Row]
    private Space[][] spaces;
    private int spacesSelected;
    private int mines;

    public Board(int size, int mines) {
        this.mines = mines;
        spaces = new Space[size][size];
        spacesSelected = 0;
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[0].length; j++) {
                spaces[i][j] = new Space();
            }
        }
    }

    public Space getSpace(int col, int row) {
        return spaces[row][col];
    }

    public void printBoard() {
        for (Space[] col : spaces) {
            for (Space space : col) {
                System.out.print("|" + getSymbol(space));
            }
            System.out.print("|\n");
        }
    }

    private String getSymbol(Space space) {
        SpaceState ss = space.getState();
        if (ss.equals(SpaceState.Covered))
            return "?";
        else if (ss.equals(SpaceState.Bombed))
            return "X";
        else {
            int minesAround = space.getBombsAround();
            if (minesAround > 0) {
                return String.valueOf(minesAround);
            } else {
                return " ";
            }
        }
    }

    public boolean verifyWin() {
        int size = spaces.length;
        return spacesSelected >= ((size * size) - mines);
    }

    public boolean selectSpace(int[] coor) {
        Space space = getSpace(coor[0], coor[1]);
        if(!space.isCovered()) return true;
        if (space.isBomb()) {
            space.setState(SpaceState.Bombed);
            return false;
        } else {
            spacesSelected++;
            space.uncover();
           
            if (space.getBombsAround() == 0)
                uncoverAround(coor[0], coor[1]);
            return true;
        }

    }

    public void uncoverAround(int col, int row) {
        Dimension dim = new Dimension(col, row, spaces.length);
        for (int i = dim.getColStart(); i <= dim.getColEnd(); i++) {
            for (int j = dim.getRowStart(); j <= dim.getRowEnd(); j++) {
                Space space = getSpace(i, j);
                
                if(!(i==col && j==row) && space.isCovered()&&!space.isBomb()){
                    System.out.println(i+"-"+j);
                    space.uncover();
                    spacesSelected++;
                    if (space.getBombsAround()==0) {
                        System.out.println("00"+i+"-"+j);
                        uncoverAround(i, j);
                    }
                }
            }
        }
    }
}
