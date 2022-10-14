public class offer_10_1 {
    static class Solution {
        /**
         * dp
         * todo 还有logn的写法，利用矩阵快速幂
         * @param n
         * @return
         */
        public int fib(int n) {
            if (n==0) return 0;
            if (n==1) return 1;
            int p = 0, q = 0, r = 1;
            final int MOD = (int) (1e9 + 7);
            for (int i = 2; i <= n; ++i) {
                p = q;
                q = r;
                r = (p + q) % MOD;
            }
            return r;
        }
    }
    public static void main(String[] args) {

    }
}
