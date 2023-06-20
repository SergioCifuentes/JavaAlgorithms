package HashTable;

public class main {
    public static void main(String[] args) {
        Hash<Integer,String> hash = new Hash<Integer,String>(3);
        hash.put(1, "one");
        hash.put(2, "two");
        hash.put(3, "three");
        hash.put(4, "four");
        hash.put(5, "five");
        hash.put(10, "ten");
        hash.put(11, "eleven");
        hash.put(12, "twelve");
        hash.put(13, "thirteen");
        hash.put(14, "fourteen");
        hash.put(15, "fifteen");
        hash.printTable();
    }
}
