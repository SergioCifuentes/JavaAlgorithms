import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;
        
        public StackNode(T data) {
            this.data = data;
            
        }

        
    }
    private int size=0;
    private StackNode<T> top;
    
    public T pop(){
        if(top==null) throw new EmptyStackException();
        T items = top.data;
        top=top.next;
        size--;
        return items;

    }

    public void push(T item){
        StackNode<T> node = new StackNode(item);
        node.next=top;
        top=node;
        size++;
    }

    public int getSize(){
        return size;
    }
    public String toString(){
        if(isEmpty())return "]";
        T item=  pop();
        String value = String.valueOf(item);
        String result =value+"-"+toString();
        push(item);
        return result;
    }

    public T peek(){
        if(top==null) throw new EmptyStackException();
        return top.data;
    }
    public T min(){
        if (this.isEmpty()) return null;
        T data = pop();
        T nextData=min();
        push(data);
        if(nextData==null){
            return data;
        }else{
            return (int)data > (int)nextData ? nextData : data;
        }
    }

    public boolean isEmpty(){
        return top==null;
    }
}
