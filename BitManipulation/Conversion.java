public class Conversion {
    public static void main(String[] args) {
        int n1=29;
        int n2=15;
        System.out.println(getConversionNumber(n1, n2));

    }

    public static int getConversionNumber(int n1,int n2){
        if (n1==n2) {
            return 0;
        }
        int count=0;
        for (int i = 0; i < Integer.BYTES*8; i++) {
            if((n1&1)!=(n2&1)){
                count++;
            }
            n1>>>=1;
            n2>>>=1;
        }
        return count;
    }
}
