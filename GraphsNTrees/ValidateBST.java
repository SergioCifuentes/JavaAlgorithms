public class ValidateBST {
    public static void main(String[] args) {
        TreeNode bt = ListOfDepths.createBinaryTree();
        System.out.println(isBST(bt).bst);
        System.out.println(isBST2(bt,null,null));
        TreeNode bst = ListOfDepths.createBinarySearchTree();
        System.out.println(isBST(bst).bst);
        System.out.println(isBST2(bst,null,null));
    }

    static class Result{
        boolean bst;
        int greater;
        public Result(boolean bst, int greater) {
            this.bst = bst;
            this.greater = greater;
        }       
    }

    public static Result isBST(TreeNode node){
        
        if(node.leftNode!=null){
            Result leftR = isBST(node.leftNode);
            if(!leftR.bst) return leftR;
            if(leftR.greater>node.getValue()){
                return new Result(false,node.getValue());
            }
        }
        if(node.rightNode!=null){
            Result rightR = isBST(node.rightNode);
            if(!rightR.bst||node.getValue()<= rightR.greater){
                return rightR;
            }else{
                return new Result(false,node.getValue());
            }
        }
        return new Result(true,node.getValue());
        
    }

    public static boolean isBST2(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        if((min!=null && node.getValue()<=min)||(max!=null&&node.getValue()>max)){
            return false;
        }
        if(!isBST2(node.leftNode, min, node.getValue())||!isBST2(node.rightNode, node.getValue(), max)){
            return false;
        }
        return true;

    }

}
