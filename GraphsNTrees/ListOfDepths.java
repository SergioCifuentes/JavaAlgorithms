import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode head = createBinaryTree();
        ArrayList<LinkedList<String>> lists = getList(head);
        for (LinkedList<String> linkedList : lists) {
            System.out.println(linkedList.toString());
        }

    }

    public static ArrayList<LinkedList<String>> getList(TreeNode tree) {
        ArrayList<LinkedList<String>> array = new ArrayList<>();
        LinkedList<String> currentList = new LinkedList<>();
        MyQueue<TreeNode> mq = new MyQueue<TreeNode>();
        int level = 1;
        int aux = 0;
        
        TreeNode depthLimit = new TreeNode("Depth Limit");
        mq.add(tree);
        mq.add(depthLimit);
        
        while (!mq.isEmpty()) {           
            TreeNode tn = mq.remove();
            if (tn.equals(depthLimit)) {
                array.add(currentList);
                LinkedList<String> newList = new LinkedList<>();
                currentList = newList;
            } else {
                currentList.add(tn.name);
                if (tn.leftNode != null)
                    mq.add(tn.leftNode);
                if (tn.rightNode != null)
                    mq.add(tn.rightNode);
                aux += 2;
                if (aux == Math.pow(2, level)) {
                    mq.add(depthLimit);
                    level++;
                    aux=0;
                }
            }

        }

        return array;

    }
/*   1
 *  2  3
 * 4   5 6
 *7 8 
 */
    public static TreeNode createBinaryTree() {
        TreeNode head = new TreeNode("1");
        TreeNode left = new TreeNode("2");
        TreeNode right = new TreeNode("3");
        head.leftNode=left;
        head.rightNode=right;
        TreeNode leftleft=new TreeNode("4");
        left.leftNode = leftleft;
        right.leftNode = new TreeNode("5");
        right.rightNode = new TreeNode("6");
        leftleft.leftNode=new TreeNode("7");
        leftleft.rightNode=new TreeNode("8");
        return head;
    }
    /*  6
     * 4 8
     * 2 7 9
     *1 3
     */
    public static TreeNode createBinarySearchTree() {
        TreeNode head = new TreeNode("6");
        TreeNode left = new TreeNode("4");
        TreeNode right = new TreeNode("8");
        head.leftNode=left;
        head.rightNode=right;
        TreeNode leftleft=new TreeNode("2");
        left.leftNode = leftleft;
        right.leftNode = new TreeNode("7");
        right.rightNode = new TreeNode("9");
        leftleft.leftNode=new TreeNode("1");
        leftleft.rightNode=new TreeNode("3");
        return head;
    }
}
