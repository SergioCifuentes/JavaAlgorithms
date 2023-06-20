import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        // char[] array={'a','b','c','d'};
        // ArrayList<String> subsets= getSubsets(array);
        // for (String sub : subsets) {
        //     System.out.println(sub);
        // }
        // a b c d e
        // ab ac ad ae


        ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		
		ArrayList<ArrayList<Integer>> subsets2 = getSubsets(list);
		System.out.println(subsets2.toString());

    }
    public static ArrayList<String> getSubsets(char[] array){
        return getSubsets(array,"",0);
    }

    public static ArrayList<String> getSubsets(char[] array,String current,int index){
        if(index>array.length-1)return new ArrayList<>();
        ArrayList<String> subsets=new ArrayList<>();
        for (int i = index; i < array.length; i++) {
            String aux=current+array[i];
            subsets.add(aux);
            subsets.addAll(getSubsets(array, aux, i+1));
        }
        return subsets;
    }

    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
}
