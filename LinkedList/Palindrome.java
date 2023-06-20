import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
    
        Node head = new Node(7);
        head.appendToTail(1);
        head.appendToTail(6);
        head.appendToTail(1);
        head.appendToTail(7);
        System.out.println(isPalindrome(head));
        Node head2 = new Node(7);
        head2.appendToTail(1);

        head2.appendToTail(1);
        head2.appendToTail(7);
        System.out.println(isPalindrome(head2));
        Node head3 = new Node(7);
        head3.appendToTail(5);

        head3.appendToTail(1);
        head3.appendToTail(7);
        System.out.println(isPalindrome(head3));
    }

    public static boolean isPalindrome(Node head){
        //O(n)
        int size=getNodeSize(head);
        int middle = size/2;
        Stack<Integer> st= new Stack<>();

        for (int i = 0; i < middle; i++) {
            st.push(head.data);
            head=head.next;
        }
        if (size%2!=0) {
            head=head.next;
        }
        for (int i = 0; i < middle; i++) {
            if (st.pop()!=head.data) {
                return false;
            }
            head=head.next;
        }
        return true;

    }
    public static int getNodeSize(Node head){
        int size=1;

        while (head.next!=null) {
            size++;
            head=head.next;
        }
        return size;
    }

    class Result{
        public Node node;
        public boolean result;
        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
        
    }
//RECURSIVE

Result isPalindromeRecursive(Node head, int length){
    if(head==null || length <=0){//Even number of nodes
        return new Result(head,true);
    }else if(length==1){//Odd
        return new Result(head.next,true);
    }
    //Recurse on sublist
    Result res = isPalindromeRecursive(head.next, length-2);

    //If child are not a palindrome. pass back up
    if (!res.result||res.node==null) {
        return res;
    }
    //Checks it matches corresponding node on other side
    res.result=res.node.data==head.data;

    res.node=res.node.next;
    return res;
}


}
