public class NextNumber{
    public static void main(String[] args) {
        int num=13948;
        System.out.println(Integer.toBinaryString(num));
        int small=getNextSmallest(num);
        System.out.println("SMALL "+small);
        System.out.println(Integer.toBinaryString(small));
        int big=getNextLargest(num);
        System.out.println("BIG "+big);
        System.out.println(Integer.toBinaryString(big));
    }
//11011011111100
    public static int getNextSmallest(int num){
        int n=num;
        //2
        int p=0;
        boolean tail=true;
        //2
        int zero=0;
        for (int i = 0; i < Integer.BYTES*8; i++) {
            if((n&1)==1 && !tail){
                p=i;
                break;
                
            }else if((n&1)==0){
                tail=false;
                zero++;
            }
            n>>>=1;
        }

        num&=~((1<<(p+1))-1);
        num|=(1<<(p-zero+1)-1)<<(zero-1);

        
        return num;

    }
    public static int getNextLargest(int num){
        int n=num;
        int p=0;
        boolean tail=true;
        int ones=0;
        for (int i = 0; i < Integer.BYTES*8; i++) {
            if((n&1)==0 && !tail){
                p=i;
                break;
            }else if((n&1)==1){
                tail=false;
                ones++;
            }
            n>>>=1;
        }
        num|=(1<<p);
        //1<<p 000010000
        //+1   000001111
        //~   111110000
        num&=~((1<<p)-1);
        //~0 = 11111
        
        int mask = ((1<<(ones-1))-1);
        return num|mask;

    }
}