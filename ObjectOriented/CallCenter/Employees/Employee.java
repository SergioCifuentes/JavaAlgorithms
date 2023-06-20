package CallCenter.Employees;

import CallCenter.Call;
import CallCenter.CallCenter;
import CallCenter.Rank;

public abstract class Employee {
    private Rank rank;
    private Call currentCall=null;


    public Employee(CallCenter handler){
        
    }
    //the issue is resolved, finish the call
    public void callCompleted(){}

    public void escalateAndReassign(){}

    public boolean assignNewCall(){return true;}

    public boolean isFree(){return currentCall==null;}
    public Rank getRank() {
        return rank;
    }


    public void recieveCall(Call call){}
}
