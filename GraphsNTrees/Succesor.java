public class Succesor {
    public static void main(String[] args) {
        TreeNode bst = ListOfDepths.createBinarySearchTree();
        System.out.println(findSuccesor(bst).name);
    }
    public static TreeNode findSuccesor(TreeNode node){
        if (node.rightNode!=null) {
            TreeNode succesor=node.rightNode;
            while(succesor.leftNode!=null)
                succesor=succesor.leftNode;
            return succesor;
        }else if(node.parent!=null){
            TreeNode succesor=node.parent ;
            while (succesor!=null &&succesor.getValue()<=node.getValue())
                succesor=succesor.parent;
            return succesor;
        }else return null;
    }
}
