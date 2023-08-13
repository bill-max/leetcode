public class MaxSumAfterPartitioning_1043 {
    static class Solution {

        /**
         * 1,15,7,9,2,5,10    k=3
         */
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] dp = new int[n + 1];
            dp[0] = arr[0];
            for (int i = 1; i < k; i++) {
                dp[i] = arr[i] > dp[i - 1] / i ? arr[i] * (i + 1) : dp[i - 1] / i * (i + 1);
            }

            for (int i = k; i < arr.length; i++) {
                int max = arr[i];
                for (int j = i; j > i - k; j--) {
                    max = Math.max(max, arr[j]);
                    dp[i] = Math.max(dp[i], dp[j - 1] + max * (i - j + 1));
                }
            }
            return dp[arr.length - 1];
        }
    }
}
