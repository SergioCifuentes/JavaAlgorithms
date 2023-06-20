public class MinStack {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(10);
        ms.push(1);
        ms.push(3);
        ms.push(2);
        ms.push(5);
        System.out.println("Min: "+ms.min());
        System.out.println("Pop: "+ms.pop());
    }
}
