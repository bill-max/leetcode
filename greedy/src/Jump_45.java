public class Jump_45 {
    static class Solution {
        /**
         * 2,3,0,1,4
         * 每次可以到达的最大位置
         * @param nums
         * @return
         */
        public int jump(int[] nums) {
            int n = nums.length;
            int cur = 0;
            int count = 0;
            int end = 0;
            for (int i = 0; i < n-1; i++) {
                cur = Math.max(nums[i] + i, cur);
                if (i == end) {
                    end = cur;
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
