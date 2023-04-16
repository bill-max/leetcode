public class searchInsert_2_68 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        System.out.println(new searchInsert_2_68().new Solution().searchInsert(new int[]{1, 3, 5, 6}, 4));
    }
}
