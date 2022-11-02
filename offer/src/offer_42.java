public class offer_42 {
    static class Solution {
        /**
         * dp 问题
         *
         * dp[i]==>以i为结尾的数组的 最大和
         * dp[i]=max(nums[i],dp[i-1]+nums[i])
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length+1];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(dp[i], max);
            }
            return max;
        }

        /**
         * 空间优化
         * @param nums
         * @return
         */
        public int maxSubArray2(int[] nums) {
            int preMax=nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preMax = Math.max(nums[i], preMax + nums[i]);
                max = Math.max(preMax, max);
            }
            return max;
        }
    }
}
