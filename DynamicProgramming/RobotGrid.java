import java.util.ArrayList;
import java.util.HashMap;

public class RobotGrid {
    public static void main(String[] args) {
        boolean[][] grid={{true,true,true,true,true},
                          {true,true,true,false,true},
                          {true,true,true,false,true},
                          {false,false,true,false,true}};
        ArrayList<Move> moves = findPath(grid,0,0);
        if(moves==null){
            System.out.println("NO PATHS");
        }else{
            for (Move move : moves) {
                System.out.printf(move.toString()+"->");
            }
        }
        moves = findPath(grid,0,0,new HashMap<Integer,Integer>());
        if(moves==null){
            System.out.println("NO PATHS");
        }else{
            for (Move move : moves) {
                System.out.printf(move.toString()+"->");
            }
        }
        

    }

    public static ArrayList<Move> findPath(boolean[][] grid,int row,int column){
        if((row+1==grid.length-1&&column==grid[0].length-1)){
            ArrayList<Move> down =new ArrayList<Move>();
            down.add(Move.DOWN);
            return down;
        }
        if(row==grid.length-1&&column+1==grid[0].length-1){
            ArrayList<Move> right =new ArrayList<Move>();
            right.add(Move.RIGHT);
            return right;
        }
        if(row+1<grid.length&&grid[row+1][column]){
            ArrayList<Move> downPaths = findPath(grid, row+1, column);
            if(downPaths!=null){
                ArrayList<Move> down =new ArrayList<Move>();
                down.add(Move.DOWN);
                down.addAll(downPaths);
                return down;
            }

        }
        if(column+1<grid[0].length&&grid[row][column+1]){
            ArrayList<Move> rightPaths = findPath(grid, row, column+1);
            if(rightPaths!=null){
                ArrayList<Move> right =new ArrayList<Move>();
                right.add(Move.RIGHT);
                right.addAll(rightPaths);
                return right;
            }
        }
        return null;
    }


    public static ArrayList<Move> findPath(boolean[][] grid,int row,int column,HashMap<Integer,Integer> memo){
        if(memo.containsKey(row)&&memo.get(row)==column){
            return null;
        } 
        if((row+1==grid.length-1&&column==grid[0].length-1)){
            ArrayList<Move> down =new ArrayList<Move>();
            down.add(Move.DOWN);
            return down;
        }
        if(row==grid.length-1&&column+1==grid[0].length-1){
            ArrayList<Move> right =new ArrayList<Move>();
            right.add(Move.RIGHT);
            return right;
        }
        if(row+1<grid.length&&grid[row+1][column]){
            ArrayList<Move> downPaths = findPath(grid, row+1, column,memo);
            if(downPaths!=null){
                ArrayList<Move> down =new ArrayList<Move>();
                down.add(Move.DOWN);
                down.addAll(downPaths);
                return down;
            }

        }
        if(column+1<grid[0].length&&grid[row][column+1]){
            ArrayList<Move> rightPaths = findPath(grid, row, column+1,memo);
            if(rightPaths!=null){
                ArrayList<Move> right =new ArrayList<Move>();
                right.add(Move.RIGHT);
                right.addAll(rightPaths);
                return right;
            }
        }
        memo.put(row, column);
        return null;
    }

    private enum Move{
        DOWN,RIGHT;
        public String toString(){
            if (this==Move.DOWN) {
                return"DOWN";
            }else{
                return "RIGHT";
            }
        }
    }
}
