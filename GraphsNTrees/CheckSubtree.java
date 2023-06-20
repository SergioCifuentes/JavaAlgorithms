public class CheckSubtree {
    public static void main(String[] args) {
        
    }
    public static boolean isSubTree(TreeNode tree,TreeNode subTree){
        if (compareTrees(tree, subTree)) {
            return true;
        }
        return isSubTree(tree.leftNode, subTree)||isSubTree(tree.rightNode, subTree);
    }

    public static boolean compareTrees(TreeNode tree,TreeNode subTree){
        if(tree==null&&subTree==null)
            return true;
        if(tree!=null&&subTree!=null &&
            tree.getValue()==subTree.getValue()){
                return compareTrees(tree.leftNode, subTree.leftNode) &&
                compareTrees(tree.rightNode,subTree.rightNode);
        }
            
        return false;
    }
}
