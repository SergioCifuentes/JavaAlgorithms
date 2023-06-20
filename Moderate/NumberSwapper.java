public class NumberSwapper{
    public static void main(String[] args) {
        Integer num1 =5;
        Integer num2 =8;
        // System.out.println("N1 "+num1+" N2 "+num2);
        // swapNumbers(num1, num2);
        // num1 =4;
        // num2 =-2;
        // System.out.println("N1 "+num1+" N2 "+num2);
        // swapNumbers(num1, num2);
        // num1 =3;
        // num2 =-3;
        // System.out.println("N1 "+num1+" N2 "+num2);
        // swapNumbers(num1, num2);
        swapNumbersBit(num1, num2);
    }

    public static void swapNumbers(Integer num1, Integer num2){
        num1=num1-num2;
        num2=num1+num2;
        num1=num2-num1;
        System.out.println("N1 "+num1+" N2 "+num2);
    }

    public static void swapNumbersBit(Integer num1,Integer num2){
        System.out.println(Integer.toBinaryString(num1));
        System.out.println(Integer.toBinaryString(num2));
        num1=num1^num2;
        System.out.println(Integer.toBinaryString(num1));
        num2=num1^num2;
        System.out.println(Integer.toBinaryString(num2));
        num1=num1^num2;
        System.out.println(Integer.toBinaryString(num1));
    }
}
