package CircularArray;

public class CircularObject<T> {
    private T object;
    private CircularObject<T> next;
    public CircularObject(T object) {
        this.object = object;
    }
    public T getObject() {
        return object;
    }
    public void setObject(T object) {
        this.object = object;
    }
    public CircularObject<T>  getNext() {
        return next;
    }
    public void setNext(CircularObject<T>  next) {
        this.next = next;
    }

    
}
