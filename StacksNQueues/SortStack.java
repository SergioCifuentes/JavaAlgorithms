public class SortStack {
    public static void main(String[] args) {
        MyStack<Integer> ms= new MyStack<>();
        
        ms.push(2);
        ms.push(6);
        ms.push(1);
        ms.push(5);
        ms.push(3);
        System.out.println(ms.toString());
        sortStack(ms);
        System.out.println(ms.toString());
    }
    public static void sortStack(MyStack<Integer> ms){
        MyStack<Integer> temp= new MyStack<>();
        while(!ms.isEmpty()){
            temp.push(getMaxInt(ms));
        }
        System.out.println(temp.toString());
        while(!temp.isEmpty()){
            ms.push(temp.pop());
        }
    }
    public static Integer getMaxInt(MyStack<Integer> ms){
        Integer num = (Integer)ms.pop();
        if(ms.isEmpty()){
            return num;
        }
        Integer nextMax=getMaxInt(ms);
        if(num<nextMax){
            ms.push(num);
            return nextMax;
        }else{
            ms.push(nextMax);
            return num;
        }
        
    }
    public static void sortStack2(MyStack<Integer> ms){
        MyStack<Integer> temp= new MyStack<>();
        while(!ms.isEmpty()){
            Integer next=ms.pop();
            while (!temp.isEmpty() &&temp.peek()>next) {
                ms.push(temp.pop());
            }
            temp.push(next);
        }
        while(!temp.isEmpty()) ms.push(temp.pop());

    }
}
