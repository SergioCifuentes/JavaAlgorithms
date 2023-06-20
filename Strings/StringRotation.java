public class StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1,s2));
    }
    public static boolean isRotation(String s1, String s2){
        s2=s2+s2;

        return s2.contains(s1);
    }
}
