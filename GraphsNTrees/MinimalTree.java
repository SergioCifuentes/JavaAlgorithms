public class MinimalTree {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7};
        TreeNode treeNode=convertToTree(array);
        treeNode.print();


    }
    public static TreeNode convertToTree(Integer[] array){
        int middleIndex=(array.length/2);
        TreeNode treeNode= new TreeNode(String.valueOf(array[middleIndex]));
        if(array.length>2){
            treeNode.leftNode=convertToTree(subArray(array, 0, middleIndex-1));
            treeNode.rightNode=convertToTree(subArray(array, middleIndex+1, array.length-1));
        }else if(array.length==2){
            treeNode.leftNode=convertToTree(subArray(array, 0, 0));
        }
        return treeNode;
        

    }
    public static Integer[] subArray(Integer[] array, int startIndex,int endIndex){
        Integer[] result = new Integer[endIndex-startIndex+1];
        int aux =0;
        for (int i = startIndex; i <= endIndex; i++) {
            result[aux]=array[i];
            aux++;
        }
        return result;

    }
}
