import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BSTSequence {
    public static void main(String[] args) {
        TreeNode tn = ListOfDepths.createBinarySearchTree();
        ArrayList<LinkedList<Integer>> array =allSequences(tn);
        for (LinkedList<Integer> linkedList : array) {
            System.out.println(Arrays.toString(linkedList.toArray()));
        }
    }
    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if(node==null){
            result.add(new LinkedList<Integer>());     
            return  result;       
        }
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.getValue());
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.leftNode);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.rightNode);
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved=new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right,weaved,prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }
    public static void weaveLists(LinkedList<Integer> first,LinkedList<Integer> second,
        ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix){
            if(first.size()==0||second.size()==0){
                LinkedList<Integer> result=(LinkedList<Integer>)prefix.clone();
                result.addAll(first);
                result.addAll(second);
                results.add(result);
                return;
            }
            
            int headFirst= first.removeFirst();
            prefix.addLast(headFirst);
            weaveLists(first, second, results, prefix);
            prefix.removeLast();
            first.addFirst(headFirst);

            int headSecond= second.removeFirst();
            prefix.addLast(headSecond);
            weaveLists(first, second, results, prefix);
            prefix.removeLast();
            second.addFirst(headSecond);
    }
    
}
