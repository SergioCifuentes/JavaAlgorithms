public class DeleteMiddle {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendToTail(4);
        head.appendToTail(6);
        head.appendToTail(2);
        head.appendToTail(7); 
        Node nodeDelete=head.appendToTail(5);
        head.appendToTail(1);
        head.appendToTail(10);
        int middle = 5;
        head.printList();
        System.out.printf("\nDelete %s\n",middle);
        deleteMiddle(nodeDelete, middle);
        head.printList();
    }
    public static void deleteMiddle(Node node, int middle ){
        if(node==null||node.next==null){
            System.out.println("fail");
        }else{
            node.data=node.next.data;
            node.next=node.next.next;
        }
    }
}
