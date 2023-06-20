import java.util.Random;

public class BinarySearchTree {
    public BSTNode head = null;
    public static class BSTNode{
        public int value;
        public BSTNode left;
        public BSTNode right;
        int size = 0;
        public BSTNode(int value) {
            this.value = value;
            size=1;
        }
        public int size(){
            return size;
        }
        public BSTNode getIthNode(int i){
            int leftSize = left ==null ? 0 :left.size();
            if(i < leftSize){
                return left.getIthNode(i);
            }else if(i == leftSize){
                return this;
            }else{
                return right.getIthNode(i-(leftSize+1));
            }
        }
        
        public void insertInOrder(int d){
            if(d<= value){
                if (left==null) {
                    left = new BSTNode(d);
                }else{
                    left.insertInOrder(d);
                }

            }else{
                if (right==null) {
                    right = new BSTNode(d);
                }else{
                    right.insertInOrder(d);
                }
            }
            size++;
        }
    }
    public int size(){
        return head== null? 0 : head.size;
    }
    public BSTNode getRandomNode(){
        if(head==null) return null;
        Random random = new Random();
        int i = random.nextInt(size());
        return head.getIthNode(i);
    }
    public void insertInOrder(int value){
        if (head == null){
            head = new BSTNode(value);
        }else{
            head.insertInOrder(value);
        }
    }
    




}
