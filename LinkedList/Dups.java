import java.util.HashSet;

public class Dups {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendToTail(4);
        head.appendToTail(4);
        head.appendToTail(2);
        head.appendToTail(3); 
        head.appendToTail(4);
        head.appendToTail(1);
        head.appendToTail(10);
        head.printList();

        //head = removeDublicate(head);
        deleteDups(head);
        System.out.println("Removed");
        head.printList();
    }

    public static Node removeDublicate(Node head){
        Node pointer1=head;
        Node pointer2=head;    
        while(pointer1.next!=null){
            if(pointer1.equals(pointer2)){
                if(pointer1.data==pointer2.next.data){
                    removeNextNode(pointer1);    
                }
            }
            pointer2=pointer2.next;
            if(pointer2.next==null){
                break;
            }
            if(pointer1.data==pointer2.next.data){        
                removeNextNode(pointer2);
            }
            if(pointer2.next.next==null){
                pointer1=pointer1.next;
                pointer2=pointer1;
            }
        }
        return head;
    }
    static void deleteDups(Node head){
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous= null;
        while(head != null){
            if (set.contains(head.data)){
                previous.next=head.next;
            }else{
                set.add(head.data);
                previous=head;
            }
            head=head.next;

        }
    }

    public static Node removeNextNode(Node node){
        if(node.next!=null){
            node.next=node.next.next;
        }
       
        return node;
    }
}
