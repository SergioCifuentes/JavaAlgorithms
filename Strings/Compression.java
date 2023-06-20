public class Compression {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(compress(input));
    }

    public static String compress(String input) {
        int counter = 0;

        Character currentChar = input.charAt(input.length() - 1);
        StringBuilder sb = new StringBuilder(input);
        for (int i = input.length() - 1; i >= 0; i--) {

            if (input.charAt(i) == currentChar) {
                counter++;
            } else {

                sb.replace(i + 1, i + counter + 1, currentChar + String.valueOf(counter));
                input = sb.toString();
                counter = 1;
                currentChar = input.charAt(i);

            }

        }
        sb.replace(0, counter, currentChar + String.valueOf(counter));
        input = sb.toString();

        return input;
    }
}
