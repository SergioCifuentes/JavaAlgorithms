package CircularArray;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private CircularObject<T> start;
    private CircularObject<T> end;

    public void insert(T object){
        if (start!=null &&end!=null) {
            CircularObject<T> newObj=new CircularObject<T>(object);
            newObj.setNext(start);
            end.setNext(newObj);
            end=newObj;
        }else if(start==null){
            start=new CircularObject<T>(object);
            
            start.setNext(start);
            
        }else if(end==null){
            CircularObject<T> newObj=new CircularObject<T>(object);
            start.setNext(newObj);
            end=newObj;
            end.setNext(start);
        }
        
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>(){
            CircularObject<T> current = end;
            @Override
            public boolean hasNext() {
                return current.getNext()!=null;
            }

            @Override
            public T next() {
                current =current.getNext();
                return current.getObject();
            }

        };
        return it;
    }

}
