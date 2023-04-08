import java.math.BigInteger;

public class monkeyMove {
    static class Solution {
        private final int MOD = (int) Math.pow(10, 9) + 7;

        public int monkeyMove(int n) {
            BigInteger b = BigInteger.valueOf(2);
            return b.modPow(BigInteger.valueOf(n), BigInteger.valueOf(100000007)).subtract(BigInteger.TWO).intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
