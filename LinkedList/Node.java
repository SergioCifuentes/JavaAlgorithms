public class Node {
    Node next = null;
    int data;

    public Node (int d){
        data=d;
    }
    public Node (){

    }
        
    public void setNext(Node next) {
        this.next = next;
    }
    public void setData(int data) {
        this.data = data;
    }
    Node appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n=n.next;
        }
        n.next=end;
        return end;
    }


    void printList(){
        System.out.print(data);
        Node n = this;
        while(n.next != null){
            n=n.next;
            System.out.print(" -> "+n.data);
            
        }
    }
}
