import java.util.HashMap;

public class PathsWithSum {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createBinaryTree();
        tree.print();
        System.out.println(getPathsSum(tree, 8, 0));
        System.out.println(countPathsWithSum(tree, 8,
                0, new HashMap<Integer, Integer>()));

    }

    public static int getPathsSum(TreeNode node, int value, int total) {
        int paths = 0;
        total += node.getValue();
        if (total == value) {
            paths++;
        }
        if (node.leftNode != null) {
            paths += getPathsSum(node.leftNode, value, total);
            paths += getPathsSum(node.leftNode, value, 0);
        }
        if (node.rightNode != null) {
            paths += getPathsSum(node.rightNode, value, total);
            paths += getPathsSum(node.rightNode, value, 0);
        }
        return paths;
    }

    static int countPathsWithSum(TreeNode node, int targetSum, int runningSum,
            HashMap<Integer, Integer> pathCount) {
        if (node == null)
            return 0;
        runningSum+=node.getValue();
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        if (runningSum == targetSum) {
            totalPaths++;
        }
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.leftNode, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.rightNode, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;

    }

    static void incrementHashTable(HashMap<Integer, Integer> hashMap, int key, int delta) {
        int newCount = hashMap.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashMap.remove(key);
        } else {
            hashMap.put(key, newCount);
        }

    }
}
