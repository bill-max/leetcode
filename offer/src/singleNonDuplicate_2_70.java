public class singleNonDuplicate_2_70 {
    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums.length == 1) return nums[0];
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == nums[mid ^ 1]) {
                    l = mid + 1;
                } else
                    r = mid;
            }
            return nums[l];

        }
    }
}
