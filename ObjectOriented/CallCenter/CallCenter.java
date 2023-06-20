package CallCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import CallCenter.Employees.Employee;

public class CallCenter {
    private final int LEVELS=3;
    private final int NUM_RESPONDENTS=10;
    private final int NUM_MANAGERS=4;
    private final int NUM_DIRECTORS=2;
    
    List<List<Employee>> employeesLevels;

    List<List<Call>> callQueues;

    public CallCenter(){}


    public Employee getHandlerForCall(Call call){
        return null;
    }
    public void dispachCall(Call call){
        Employee em = getHandlerForCall(call);
        if(em!=null){
            em.recieveCall(call);
            call.setHandler(em);
        }else{
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }
    public boolean assignCall(Employee emp){
        return true;
    }
}
