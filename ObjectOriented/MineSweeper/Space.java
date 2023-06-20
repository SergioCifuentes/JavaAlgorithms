package MineSweeper;

public class Space {
    private SpaceState state;
    private boolean isBomb;
    private int bombsAround;
    
    
    public Space() {
        bombsAround=0;
        state=SpaceState.Covered;
        isBomb=false;
    }
    public void setIsBomb(boolean isBomb){
        this.isBomb=isBomb;
    }

    public void setState(SpaceState state) {
        this.state = state;
    }

    public void uncover(){
        state=SpaceState.Uncovered;
    }
    public boolean isCovered(){
        return state==SpaceState.Covered;
    }

    public void setBombsAround(int bombsAround) {
        this.bombsAround = bombsAround;
    }

    public SpaceState getState() {
        return state;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public int getBombsAround() {
        return bombsAround;
    }

    public void addBombsArround(){
        bombsAround++;
    }
    
    

}
