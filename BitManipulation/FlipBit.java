public class FlipBit {
    public static void main(String[] args) {
        //11011101111
        System.out.println(getLongestSequence(1775));
       //System.out.println(Integer.BYTES*8);
    }
    public static int getLongestSequence(int num){
        if(~num==0) return Integer.BYTES*8;
        int max=1;
        int previousLength=0;
        int currentLength=0;
        while(num!=0){
            if((num&1)==1){
                currentLength++;
            }else{
                previousLength=(num&2)==0?0:currentLength;
                currentLength=0;
            }
            max=Math.max(max, currentLength+previousLength+1);
            num>>>=1;
        }
        return max;
    }
}
