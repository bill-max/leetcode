public class MaxAscendingSum_1800 {
    static class Solution {
        public int maxAscendingSum(int[] nums) {
            if (nums.length==1) return nums[0];
            int maxSum=nums[0],curSum=nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    curSum = nums[i];
                } else {
                    curSum += nums[i];
                }
                maxSum = Math.max(maxSum, curSum);
            }
            return maxSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAscendingSum(new int[]{100,10,1}));
    }
}
