public class MyQueueS<T> {
    private MyStack<T> msq;
    private MyStack<T> temp;
    
    public MyQueueS() {
        this.msq = new MyStack<T>();
        this.temp = new MyStack<T>() ;
    }
    public void add(T item){
        if(!isTempEmpty()){
            shiftToMSQ();   
        }
        msq.push(item);
        
    }
    public T remove(){
        if(isTempEmpty()){
            shiftToTemp();  
        }
        return temp.pop();
    }
    public void shiftToTemp(){
        while(!msq.isEmpty()){
            temp.push(msq.pop());
        }
    }
    public void shiftToMSQ(){
        while(!temp.isEmpty()){
            msq.push(temp.pop());
        }
    }

    public T peek(){
        if(isTempEmpty()){
            shiftToTemp();  
        }
        return temp.peek();
    }

    public boolean isEmpty(){
        return msq.isEmpty()&&temp.isEmpty();
    }

    private boolean isTempEmpty(){
        return temp.isEmpty();
    }
}
