import java.util.Arrays;

public class offer_53_1 {
    static class Solution {
        /**
         * 二分查找
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchRange(int[] nums, int target) {
            return binarySearch(nums, target) - binarySearch(nums, target - 1);
        }

        public int binarySearch(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target >= nums[mid]) l = mid + 1;
                else r = mid - 1;
            }
            return l;
        }
    }
}
