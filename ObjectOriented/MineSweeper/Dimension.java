package MineSweeper;

public class Dimension {
    private int colStart;
    private int colEnd;
    private int rowStart;
    private int rowEnd;

    public String toString(){
        return "Col: "+colStart+"-"+colEnd+" Row: "+rowStart+"-"+rowEnd;
    }
    public Dimension(int colMid,int rowMid,int boardSize){
        colStart=colMid-1;
        colEnd=colMid+1;
        rowStart=rowMid-1;
        rowEnd=rowMid+1;
        if(colStart<0) colStart++;
        if(colEnd>(boardSize-1)) colEnd--;
        if(rowStart<0) rowStart++;
        if(rowEnd>(boardSize-1)) rowEnd--;
    }

    public int getColStart() {
        return colStart;
    }
    public int getColEnd() {
        return colEnd;
    }
    public int getRowStart() {
        return rowStart;
    }
    public int getRowEnd() {
        return rowEnd;
    }

    
}
