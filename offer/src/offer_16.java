public class offer_16 {
    static class Solution {
        /**
         * 快速幂 O(log n) 分治思想  pow(x,4)=pow(x,2) * pow(x,2)
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            long N = n;
            return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        private double quickMul(double x, long n) {
            if (n == 0) return 1.0;
            double y = quickMul(x, n / 2);
            return n % 2 == 0 ? y * y : y * y * x;
        }
    }
}
