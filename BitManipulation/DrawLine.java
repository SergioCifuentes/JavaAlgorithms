public class DrawLine {
    public static void main(String[] args) {
        byte[] screen=new byte[24];
        
        int w =24;

        printScreen(drawLine(screen, w, 16, 16, 3), w);
    }

    public static byte[] drawLine(byte[] screen, int w, int x1, int x2, int y){
        int min = x1>x2?x2:x1;
        int max = x1>x2?x1:x2;
        int arrayStart=((w/8)*y);
        
        int horrizonSkip=min/8;
        int bitStart=min-(8*horrizonSkip);
        byte currentByte=screen[arrayStart+horrizonSkip];
        
        if(max<8*(horrizonSkip+1)){
            int bitEnd=8- (8*(horrizonSkip+1)- max);
            screen[arrayStart+horrizonSkip]=fillWithOnes(currentByte,bitStart,bitEnd);
            return screen;
        }else{
            screen[arrayStart+horrizonSkip]=fillWithOnes(currentByte,bitStart,7);
        }
        horrizonSkip++;
        System.out.println(8*(horrizonSkip+1));
        while (8*(horrizonSkip+1)<max) {
            
            currentByte=screen[arrayStart+horrizonSkip];
            screen[arrayStart+horrizonSkip]=fillWithOnes(currentByte,0,7);
            horrizonSkip++;
        }
        
        currentByte=screen[arrayStart+horrizonSkip];
        int bitEnd=max-((horrizonSkip)*8);
        System.out.println(bitEnd);
        screen[arrayStart+horrizonSkip]=fillWithOnes(currentByte,0,bitEnd);
        
        return screen;
    }
    public static byte fillWithOnes(byte b,int start,int end){
        if(end-start==7){
            b=(byte)0xFF;
            return b;
        }
        
        int mask= ((1<<end-start+1)-1)<<(7-end) ;
        return (byte)(b|mask);
    }

    public static void printScreen(byte[] screen,int w){
        int bytewidth=w/8;
        for (int i = 0; i < screen.length; i++) {
            String s2 = String.format("%8s", Integer.toBinaryString(screen[i] & 0xFF)).replace(' ', '0');
            System.out.printf("["+s2+"]");
            if((i+1)%bytewidth==0) System.out.println("");
        }
        

    }
}
