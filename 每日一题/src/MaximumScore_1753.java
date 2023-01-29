import java.util.Arrays;

public class MaximumScore_1753 {
    static class Solution {
        /**
         * 1 1 1
         * 1 2 1
         * 1 2 5
         * 2 2 2
         * 每次将最大的两个数减一
         */
        public int maximumScore(int a, int b, int c) {
            int[] nums = new int[]{a, b, c};
            Arrays.sort(nums);
            int ans = 0;
            while (nums[1] != 0 || nums[0] != 0) {
                nums[1]--;
                nums[2]--;
                ans++;
                Arrays.sort(nums);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(1,2,2));
    }
}
