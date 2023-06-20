package FileDuplicates;

public class BitSet {
    int [] bitSet;

    public BitSet(int size) {
        bitSet=new int[(size>>5)+1];
    }

    boolean get(int pos){
        int wordNumber =(pos>>5);
        int bitNumber=(pos & 0x1F);
        return (bitSet[wordNumber]&(1 << bitNumber)) != 0;
    }

    void set(int pos){
        int wordNumber= (pos >> 5);
        int bitNumber=(pos & 0x1F);
        bitSet[wordNumber]|= 1<<bitNumber;
    }
    
}
