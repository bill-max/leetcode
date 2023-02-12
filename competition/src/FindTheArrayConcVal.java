public class FindTheArrayConcVal {
    static class Solution {
        public long findTheArrayConcVal(int[] nums) {
            long ans = 0;
            int i = 0, j = nums.length - 1;
            while (i < j) {
                ans += Integer.parseInt(nums[i] + Integer.toString(nums[j]));
                i++;
                j--;
            }
            if (i == j) {
                ans += nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheArrayConcVal(new int[]{1}));
    }
}
