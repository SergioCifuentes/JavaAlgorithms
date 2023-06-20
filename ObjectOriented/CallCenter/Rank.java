package CallCenter;

public enum Rank {
    Respondent,Manager,Director;

    public int getValue(){
        if(this==Director){
            return 2;
        }else if(this== Manager){
            return 1;
        }else{
            return 0;
        }
    }
}
