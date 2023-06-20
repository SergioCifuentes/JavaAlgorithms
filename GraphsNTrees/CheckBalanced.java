public class CheckBalanced {
    static class Result {
        public boolean balanced;
        public int lvl;

        Result(boolean balanced, int lvl) {
            this.balanced = balanced;
            this.lvl = lvl;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = ListOfDepths.createBinaryTree();
        System.out.println(isBalanced(tree, 1).balanced);
    }

    public static Result isBalanced(TreeNode node, int level) {
        if (node == null)
            return new Result(true, level - 1);
        Result leftR = isBalanced(node.leftNode, level + 1);
        Result rightR = isBalanced(node.rightNode, level + 1);
        if (!leftR.balanced || !rightR.balanced) {
            return new Result(false, level);
        } else {
            if (Math.abs(leftR.lvl - rightR.lvl) > 1) {
                return new Result(false, level);
            } else {
                int max = leftR.lvl > rightR.lvl ? leftR.lvl : rightR.lvl;
                return new Result(true, max);
            }
        }
    }
}
