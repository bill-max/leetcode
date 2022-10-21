public class offer_14_1 {
    static class Solution {
        /**
         * 整数拆分
         * 7 -> 3 + 4=12
         * 8 -> 4 + 4 -> 3+3+2=18
         * 9 -> 5 + 4=20 -> 3+3+3=27
         * 10 -> 6 + 4 -> 3 + 3 + 4=36
         *
         * @param n
         * @return
         */
        public int cuttingRope(int n) {
            if (n <= 3) return n - 1;
            int count = n / 3;
            int mod = n % 3;
            int ans = (int) Math.pow(3, count);
            if (mod == 1) {
                ans = ans / 3 * 4;
            } else if (mod == 2) {
                ans = ans * mod;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}
