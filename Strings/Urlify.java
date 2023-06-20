public class Urlify {
    public static void main(String[] args) {
        char[] array = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        int size = 13;
        System.out.println(urlify(array, size));
    }

    public static char[] urlify(char[] array, int size){
        int aux=0;
        for (int i = size-1; i>=0; i--) {
            if(array[i]==' '){
                addChars(array, aux);
                aux+=3;
            }else{
                array[array.length-1-aux]=array[i];
                aux++;
            }
            
        }
        return array;
    }
    public static void addChars(char[] array, int aux){
        array[array.length-3-aux]='%';
        array[array.length-2-aux]='2';
        array[array.length-1-aux]='0';
        
    }
}
