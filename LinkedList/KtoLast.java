public class KtoLast {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendToTail(4);
        head.appendToTail(6);
        head.appendToTail(2);
        head.appendToTail(7); 
        head.appendToTail(5);
        head.appendToTail(1);
        head.appendToTail(10);
        int k = 2;
        System.out.println(findKtoLast(head, k));
    }
    public static String findKtoLast(Node head,int k){
        Node last=head;
        Node kNode=head;
        for (int i = 0; i < k-1; i++) {
            if(last.next!=null){
                last=last.next;
            }else{
                return "Does not exist";
            }
        }
        while(last.next!=null){
            kNode=kNode.next;
            last=last.next;
        }
        return String.valueOf(kNode.data);
    }
}
