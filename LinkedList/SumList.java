public class SumList {
    public static void main(String[] args) {
        //617+295
        Node head1 = new Node(7);
        head1.appendToTail(1);
        head1.appendToTail(6);

        Node head2 = new Node(5);
        head2.appendToTail(9);
        head2.appendToTail(2);
        sumLists(head1, head2).printList(); 
        System.out.println("\n============");
        Node head3 = new Node(6);
        head3.appendToTail(1);
        head3.appendToTail(7);

        Node head4 = new Node(2);
        head4.appendToTail(9);
        head4.appendToTail(5);
        sumList2(head3, head4).printList(); 
    }

    public static Node sumLists(Node head1, Node head2){
        Node result=null;
        int carry=0;
        while(head1!=null && head2!=null){
            Integer sum = head1.data+head2.data+carry;
            int nodeData=0;
            if((int)(Math.log10(sum)+1)==2){
                nodeData=sum%10;
                sum=sum/10;
                carry = sum%10;
            }else{
                nodeData=sum;
                carry=0;
            }
            if (result==null) {
                result= new Node(nodeData);
            }else{
                result.appendToTail(nodeData);
            }
            head1=head1.next;
            head2=head2.next;    
        }
        return result;
    }

    public static Node sumList2(Node head1, Node head2){
        Node carry =null;
        int carryInt=0;
        if(head1.next!=null &&head2.next!=null){
            carry=sumList2(head1.next, head2.next);
            if ((int)(Math.log10(carry.data)+1)==2) {
                int firstDigit=carry.data%10;
                carry.data=carry.data/10;
                carryInt = carry.data%10;
                carry.data=firstDigit;
            }
        }
        int sum=head1.data+head2.data+carryInt;
        Node node= new Node(sum);
        node.next=carry;
        return node;
    }
}
