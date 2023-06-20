import java.util.HashMap;

public class LoopDetection {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.appendToTail(1);
        head1.appendToTail(6);
        head1.appendToTail(9);
        Node loop =head1.appendToTail(10);
        head1.appendToTail(2);
        Node endNode=head1.appendToTail(9);
        endNode.setNext(loop);
        //7-1-6-9-10-2-9-10-9...

        System.out.println("Loop start:"+findLoop2(head1).data);

    }
    public static Node findLoop(Node head){
        HashMap<Node,Integer> hm= new HashMap<>();
        while(head!=null){
            if(hm.containsKey(head)){
                return head;
            }else{
                hm.put(head,1);
                head=head.next;
            }
        }
        return null;
    }
    public static Node findLoop2(Node head){
        
        Node collisionNode=findCollisionSpot(head);
        if (collisionNode==null) {
            System.out.println("No loop found");
            return null;
        }
        while (!head.equals(collisionNode)) {
            head=head.next;
            collisionNode=collisionNode.next;
        }
        return head;
    }

    public static Node findCollisionSpot(Node head){
        Node slowRunner = head;
        Node fastRunner = head;
        do {
            
            slowRunner=slowRunner.next;
            fastRunner=fastRunner.next.next;
        } while (!slowRunner.equals(fastRunner)&&fastRunner.next.next!=null);
        if(fastRunner.next.next==null)return null;
        return fastRunner;
    }
}
