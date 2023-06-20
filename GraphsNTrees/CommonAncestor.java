public class CommonAncestor {
    /*   1
 *  2  3
 * 4 9 5 6
 *7 8 
 */
    public static void main(String[] args) {
        TreeNode head = new TreeNode("1");
        TreeNode left = new TreeNode("2");
        TreeNode right = new TreeNode("3");
        head.leftNode=left;
        head.rightNode=right;
        TreeNode leftleft=new TreeNode("4");
        left.leftNode = leftleft;
        TreeNode nine=new TreeNode("9");
        left.rightNode = nine;
        
        TreeNode five=new TreeNode("5");
        right.leftNode = five;
        TreeNode six=new TreeNode("6");
        right.rightNode = six;
        leftleft.leftNode=new TreeNode("7");
        TreeNode eight=new TreeNode("8");
        leftleft.rightNode=eight;

        System.out.println(getCommonAncestor(five, six, head).name);
        System.out.println(getCommonAncestor(nine, eight, head).name);
    }
    public static TreeNode getCommonAncestor(TreeNode first, TreeNode second, TreeNode root){
        MyQueue<TreeNode> queue= new MyQueue<TreeNode>();
        queue.add(root.leftNode);
        boolean firstLeft=false;
        boolean secondLeft=false;
        //left search first
        while (!queue.isEmpty()) {
            TreeNode next=queue.remove();
            if (next.equals(first))
                firstLeft=true;
            else if (next.equals(second))
                secondLeft=true;
            if (firstLeft&&secondLeft&&root.leftNode!=null) {
                return getCommonAncestor(first, second, root.leftNode);
            }
            if (next.leftNode!=null)
                queue.add(next.leftNode);
            if (next.rightNode!=null)
                queue.add(next.rightNode);
                    
        }
        if (!secondLeft&&!firstLeft&&root.rightNode!=null) {
            return getCommonAncestor(first, second, root.rightNode);
        }
        else{
            return root;
        }
    }
}
