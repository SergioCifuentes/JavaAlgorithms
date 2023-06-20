public class Partition {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10); 
        head.appendToTail(2);
        head.appendToTail(1);
        int partition = 5;
        head.printList();
        System.out.println("Particion");
        head = partitionList(head, partition);
        head.printList();
       
    }

    public static Node partitionList(Node node, int partition){
        Node runner= node;
        
        while(runner.next!=null){
            System.out.println(runner.next.data);
            if (runner.next.data<partition) {
                Node newHead= new Node(runner.next.data);
                newHead.next=node;
                System.out.println("x");
                newHead.printList();
                System.out.println("x");
                node=newHead;
                //delete runner
              
                runner.next=runner.next.next;
            }else{
                runner=runner.next;
            }
            
        }
        return node;
    }
}
