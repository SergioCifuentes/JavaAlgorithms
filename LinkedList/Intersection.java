public class Intersection {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.appendToTail(1);
        head1.appendToTail(6);
        Node end1 =head1.appendToTail(1);
        
        Node head2 = new Node(3);
        head2.appendToTail(2);
        head2.appendToTail(9);
        head2.appendToTail(1);
        head2.appendToTail(6);
        Node end2 =head2.appendToTail(20);

        Node intersection = new Node(10);
        intersection.appendToTail(11);
        intersection.appendToTail(12);
        
        end1.setNext(intersection);
        end2.setNext(intersection);
        System.out.println(getIntersection(head1, head2).data);
        //head1 = 7, 1, 6, 1, 10, 11, 12
        //head2 = 3, 2, 9, 1, 6,  20, 10, 11, 12

    }

    public static Node getIntersection(Node head1,Node head2){
        Node runner1=head1;
        Node runner2=head2;
        int size=1;
        while(runner1.next!=null || runner2.next!=null){
            if(runner1.next==null){
                head2=head2.next;
                runner2=runner2.next;
            }else if(runner2.next==null){
                head1=head1.next;
                runner1=runner1.next;
            }else{
                runner1=runner1.next;
                runner2=runner2.next;
                size++;
            }
        }
        
        for (int i = 0; i < size; i++) {
            if(head1.equals(head2)){
                return head1;
            }else{
                head1=head1.next;
                head2=head2.next;
            }
        }
       return null;
    }
}
