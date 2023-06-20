import java.util.Arrays;
import java.util.HashMap;

public class Coins {
    enum Coin {
        Quater(25), Dime(10), Nickel(5), Penny(1);

        private int value;

        private Coin(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public static void main(String[] args) {
        int n = 15;
        HashMap map = new HashMap<Integer,HashMap>();
        Coin[] coins = { Coin.Quater, Coin.Dime, Coin.Nickel, Coin.Penny };
        System.out.println(getWays(n, coins));

    }

    public static int getWays(int n, Coin[] coins) {
        if (n == 0)
            return 1;
        if (coins.length == 1) {
            int sum = coins[0].value;
            while (sum <= n) {
                if (sum == n)
                    return 1;
                sum += coins[0].value;
            }
            return 0;
        }
        int ways = 0;
        int sum = 0; 
        while (sum <= n) {
            ways += getWays(n - sum, Arrays.copyOfRange(coins, 1, coins.length));
            sum += coins[0].value;
        }
        return ways;
    }

    public static int getWays2(int n, Coin[] coins,HashMap<Integer,HashMap<Coin,Integer>> map) {
        if (n == 0)
            return 1;
        if(map.get(n).containsKey(coins[0]))
            return map.get(n).get(coins[0]);
        if (coins.length == 1) {
            int sum = coins[0].value;
            while (sum <= n) {
                if (sum == n)
                    return 1;
                sum += coins[0].value;
            }
            return 0;
        }
        int ways = 0;
        int sum = 0; 
        while (sum <= n) {  
            ways += getWays(n - sum, Arrays.copyOfRange(coins, 1, coins.length));
            sum += coins[0].value;
        }
        if(map.containsKey(n)){
            map.get(n).put(coins[0], ways);
        }else{
            HashMap<Coin,Integer> newMap= new HashMap<Coin,Integer>();
            newMap.put(coins[0], ways); 
            map.put(n,newMap);
        }
        return ways;
    }
}
