public class offer_53_2 {
    static class Solution {
        public int missingNumber(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mid>=nums[mid]) l = mid + 1;
                else r = mid - 1;
            }
            return l;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{1,2}));
    }
}
