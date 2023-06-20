public class BitManipulation {
    public static void main(String[] args) {
        int x=100;
        System.out.println(Integer.toBinaryString(x));
        
        System.out.println(getBit(x, 3));
        System.out.println(getBit(x, 2));

    }
    public static boolean getBit(int num, int index){
        return((num&(1<<index))!=0);
    }
    public static int setBit(int num, int index){
        return (num|(1<<index));
    }
    public static int clearBit(int num, int index){
        int mask =~(index<<index);
        return num&mask;
    }
    public static int clearBitMSBthroughI(int num, int index){
        int mask =index<<index-1;
        return num&mask;
    }

    public static int updateBit(int num,int i, boolean bitIs1){
        int value = bitIs1 ?1:0;
        int mask =~(1<<0);
        return (num&mask)|(value<<i);

    }
}
