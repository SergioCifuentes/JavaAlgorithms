public class TreeNode {
    public String name;
    public TreeNode leftNode;
    public TreeNode rightNode;
    public TreeNode parent;

    public TreeNode(String name){
        this.name = name;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
    public int getValue(){
        return Integer.parseInt(name);
    }
   
    public static void inOrder(TreeNode tn){
        if (tn.leftNode!=null) {
            inOrder(tn.leftNode);   
        }
        System.out.print(tn.name);
        if (tn.rightNode!=null) {
            inOrder(tn.rightNode);  
        }
        
    }
    //1234567
    public static void preOrder(TreeNode tn){
        System.out.print(tn.name);
        if (tn.leftNode!=null) {
            preOrder(tn.leftNode);   
        }
        if (tn.rightNode!=null) {
            preOrder(tn.rightNode);  
        }
    }
    public static void postOrder(TreeNode tn){
        if (tn.leftNode!=null) {
            postOrder(tn.leftNode);   
        }
        if (tn.rightNode!=null) {
            postOrder(tn.rightNode);  
        }
        System.out.print(tn.name);
    }
    public void print(){
        MyQueue<TreeNode> mq = new MyQueue<>();
        mq.add(this);
        TreeNode lineBrake=new TreeNode("Line Braker");
        mq.add(lineBrake);
        int level=1;
        int aux=0;
        while (!mq.isEmpty()) {
            TreeNode nextString = mq.remove();
            if (nextString.equals(lineBrake)) {
                System.out.println("====================");
            }else{
                System.out.print("("+nextString.name+")");
                if(nextString.leftNode!=null) mq.add(nextString.leftNode);
                if(nextString.rightNode!=null)mq.add(nextString.rightNode);    
                aux+=2;
                if(aux==Math.pow(2, level)){
                    level++;
                    aux=0;
                    mq.add(lineBrake);
                }
            }
        }
    }
/*   1
 *  2  3
 * 4   5 6
 *7 8 
 */
public static TreeNode createBinaryTree() {
    TreeNode head = new TreeNode("10");
    TreeNode left = new TreeNode("5");
    TreeNode right = new TreeNode("-3");
    head.leftNode=left;
    head.rightNode=right;
    TreeNode leftleft=new TreeNode("3");
    left.leftNode = leftleft;
    TreeNode leftright=new TreeNode("2");
    left.rightNode = leftright;
    right.rightNode = new TreeNode("11");
    leftleft.leftNode=new TreeNode("3");
    leftleft.rightNode=new TreeNode("-2");
    leftright.rightNode=new TreeNode("1");
    return head;
}


    public static void main(String[] args) {
        /*    4
         *  2   6
         * 1 3 5 7
         */
        TreeNode head = new TreeNode("4");
        TreeNode left = new TreeNode("2");
        TreeNode right = new TreeNode("6");
        head.setLeftNode(left);
        head.setRightNode(right);
        right.setLeftNode(new TreeNode("5"));
        right.setRightNode(new TreeNode("7"));
        left.setLeftNode(new TreeNode("1"));
        left.setRightNode(new TreeNode("3"));
         //1234567
        System.out.println("InOrder");
        inOrder(head);
        //4213657
        System.out.println("\nPreOrder");
        preOrder(head);
        //1325764
        System.out.println("\nPostOrder");
        postOrder(head);

    }
    
}


