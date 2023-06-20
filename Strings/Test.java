public class Test {
        public static void main(String[] args) {
            int x =9;
            int y=10;
            int z=++x+y++;
           System.out.println(y);
           
        }
        public static void main(char[] args) {
            String input = "aabcccccaaa";
            String[] array=new String[]{"A","B"};
            compress(input);
            compress2(array);
            
            
            System.out.println(array[1]);
        }
    
        public static void compress(String input) {
            input= "hey";
            
        }
        public static void compress2(String[] input) {
            input[1]= "hey";
            
        }
    }
    

