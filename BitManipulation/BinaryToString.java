public class BinaryToString {
    public static void main(String[] args) {
        double num = 0.15;
        System.out.println(convertDouble(num));
        System.out.println(convertDouble2(num));

    }
    public static String convertDouble(double num){
        if(num>=1||num<=0){
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num>0){
            if(binary.length()>=32){
                return "ERROR";
            }
            double r = num*2;
            if(r>=1){
                binary.append(1);
                num=r-1;
            }else{
                binary.append(0);
                num=r;
            }
        }
        return binary.toString();
    }
    public static String convertDouble2(double num){
        if(num>=1||num<=0){
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        double f=0.50;
        while(num>0){
            if(binary.length()>=32){
                return "ERROR";
            }
            
            if(num>=f){
                binary.append(1);
                num-=f;
            }else{
                binary.append(0);
            }
            f/=2;
        }
        return binary.toString();
    }
}
