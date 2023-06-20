public class Insertion {
    public static void main(String[] args) {
        int n=853;
        System.out.println(Integer.toBinaryString(n));
        int m=19;
        System.out.println(Integer.toBinaryString(m));
        int i=2;
        int j=6;
        System.out.println(Integer.toBinaryString(insert(n, m, j, i)));
    }
    public static int insert(int n, int m,int j, int i){
        int dif=j-i+1;
        int mask = ~(((1<<dif)-1)<<i);
        return (n&mask)|(m<<i);
    } 
}
