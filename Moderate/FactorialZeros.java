/*  1   1                       1
 *  2   1*2                     2
 * 3    1*2*3                   6
 * 4    1*2*3*4                 24
 * 5    1*2*3*4*5               120
 * 6    1*2*3*4*5*6             720
 * 7    1*2*3*4*5*6*7           5040
 * 8    1*2*3*4*5*6*7*8         40320
 * 9    1*2*3*4*5*6*7*8*9       362880
 * 10   1*2*3*4*5*6*7*8*9*10    3628800
 *      1*2*3*4*5*6*7*8*9*10*11
 *      1*2*3*4*5*6*7*8*9*10*11*12
 *      1*2*3*4*5*6*7*8*9*10*11*12*13
 */
public class FactorialZeros {
    static int countFactZeros(int num){
        int count =0;
        if (num < 0){
            return -1;
        }
        for (int i = 5; num / i > 0; i*=5){
            count+=num/i;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(countFactZeros(25));
        System.out.println(countFactZeros(50));
    }
}
