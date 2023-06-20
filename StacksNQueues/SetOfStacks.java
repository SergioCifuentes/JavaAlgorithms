import java.util.ArrayList;

public class SetOfStacks<T> {
    private int size=3;
    private ArrayList<MyStack<T>> stacks = new ArrayList<>() ;

    public T pop(){
        MyStack<T> topStack=getLastStack();
        T item = topStack.pop();
        if (topStack.isEmpty()) stacks.remove(topStack);
        return item;
    }
    
    public void push(T item){
        if(isTopFull()){
            stacks.add(new MyStack<>());
        }
        getLastStack().push(item);
    }
    private MyStack<T> getLastStack(){
        return stacks.get(stacks.size()-1);
    }

    private boolean isTopFull(){
        
        return stacks.get(stacks.size()-1).getSize()==size;
    }
    public void printStacks(){
        for (int i = 0; i < stacks.size(); i++) {
            System.out.println(stacks.get(i).toString());
        }
    }
    public T popAt(int index){
        MyStack<T> my = stacks.get(index);
        T item=my.pop();
        if(my.isEmpty())stacks.remove(my);
        return item;
    }
    

    public SetOfStacks() {
        stacks.add(new MyStack<>());
    }

    public static void main(String[] args) {
        SetOfStacks<Integer> ss= new SetOfStacks<>();
        ss.push(10);
        ss.push(4);
        ss.push(3);
        ss.push(1);
        ss.push(3);
        ss.push(11);
        ss.push(13);
        ss.push(14);
        ss.push(32);
        ss.push(17);
        ss.printStacks();
        System.out.println(ss.pop());
        ss.printStacks();
        System.out.println(ss.popAt(1));
        ss.printStacks();
    }
}
