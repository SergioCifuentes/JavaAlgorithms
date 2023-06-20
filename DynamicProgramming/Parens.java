import java.util.ArrayList;


public class Parens {
    public static final int N=3;
    public static void main(String[] args) {
        System.out.println(getParens(1, "(", N));
    }

    public static ArrayList<String> getParens(int open,String current,int remaining){
        ArrayList<String> parens=new ArrayList<String>();
        if (open==remaining) {
            for (int i = 0; i < open; i++) {
               current+=")"; 
            }
            parens.add(current);
            
        }else{
            parens.addAll(getParens(open+1, current+"(", remaining));
            if(open>0){
                
                parens.addAll(getParens(open-1, current+")", remaining-1));
            }
        }
        
        return parens;
    }
}
