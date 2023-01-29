public class MaxProduct_152 {
    static class Solution {
        /**
         * 动态规划：-2 2 -1 3
         * dp_max[i]=max(dp_max(i-1)*nums[i],nums[i],dp_min(i-1)*nums[i])
         * dp_min[i]=min(dp_max(i-1)*nums[i],nums[i],dp_min(i-1)*nums[i])
         */
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int[] maxF = new int[length];
            int[] minF = new int[length];
            System.arraycopy(nums, 0, maxF, 0, length);
            System.arraycopy(nums, 0, minF, 0, length);
            for (int i = 1; i < length; ++i) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
                minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            }
            int ans = maxF[0];
            for (int i = 1; i < length; ++i) {
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }
    }
}
