package CallCenter;

import CallCenter.Employees.Employee;

public class Call {
    
    private Rank rank;

    private Caller caller;

    private Employee handler;

    public Call(Caller caller){
        rank = Rank.Respondent;
        this.caller=caller;
    }
    public void setHandler(Employee em){
        this.handler=em;
    }

    public void reply(String message){}

    public Rank getRank(){return rank;}

    public void setRank(Rank r){rank = r;}

    public Rank incrementRank(){return rank;}

    public void disconnect(){}


}
