public class offer_57 {
    static class Solution {
        /**
         * 经典双指针题
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                //注意防止溢出
                if (nums[l] > target - nums[r]) {
                    r--;
                } else if (nums[l] < target - nums[r]) {
                    l++;
                } else {
                    return new int[]{nums[l], nums[r]};
                }
            }
            return new int[]{-1, -1};
        }
    }
}
