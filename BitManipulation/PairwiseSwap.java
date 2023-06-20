public class PairwiseSwap {
    public static void main(String[] args) {
        //11011011111100
        int num=13948;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(swap(num)));

    }
    public static int swap(int num){
        int result=0;
        for (int i =0 ; i < Integer.BYTES*8; i+=2) {
            int x=(num&1)==0?0:2;
            num>>=1;
            x+=(num&1)==0?0:1;
            num>>=1;
            result|=(x<<i);
        }
        return result;
    }
    public static int  swapOddEvenBits(int x){
        return (x&(0xaaaaaaaa>>>1))|(x&(0x55555555<<1));
    }
}
