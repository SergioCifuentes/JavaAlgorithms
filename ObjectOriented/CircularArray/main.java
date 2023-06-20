package CircularArray;

public class main {
    public static void main(String[] args) {
        CircularArray<Integer> array = new CircularArray<Integer>();
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(5);
        int count=0;
        System.out.println("Start");
        for (Integer integer : array) {
            System.out.println(integer);
            count++;
            if(count == 10) break;
        }
        System.out.println("End");

    }
}
