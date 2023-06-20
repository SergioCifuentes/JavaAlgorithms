import java.util.Stack;

public class Hanoi {
    public static final int DISCS=3;
    public static void main(String[] args) {
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack<Integer>();
        Stack<Integer> stack3=new Stack<Integer>();
        for (int i = DISCS; i > 0; i--) {
            stack1.push(i);
        }
        Stack[] towers={stack1,stack2,stack3};
        for (Stack<Integer> tower : towers) {
            System.out.println(tower.toString());
        }
        int moves= beatHanoi(towers);
        System.out.println("In "+ moves+" moves");
        for (Stack<Integer> tower : towers) {
            System.out.println(tower.toString());
        }
    }

    public static int beatHanoi(Stack[] towers){


        return move(towers, DISCS, 0, 2);
    }

    public static int move(Stack<Integer>[] towers, int disc,int start,int end){
        if (towers[start].peek()==disc) {
            towers[end].push(towers[start].pop());
            return 1;
        }
        int moves=0;
        int opp =getOpposite(start, end);
        moves+=move(towers, disc-1, start, opp);
        towers[end].push(towers[start].pop());
        moves++;
        moves+=move(towers, disc-1, opp, end);
        return moves;
    }
    public static  int getOpposite(int start, int other){
        if(start!=0&&other!=0) return 0;
        else if(start!=1&&other!=1) return 1;
        return 2;
    }
}
