public class SortColors_75 {
    static class Solution {
        public void sortColors(int[] nums) {
            int[] color = new int[3];
            for (int num : nums) {
                color[num]++;
            }
            int ptr = 0;
            for (int i = 0; i < nums.length; i++) {
                while (color[ptr] == 0) ptr++;
                nums[i] = ptr;
                color[ptr]--;
            }
        }

        /**
         * 双指针   快排思想
         */
        public void sortColors2(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            for (int i = 0; i <= r; i++) {
                while (i <= r && nums[i] == 2) {
                    swap(nums, i, r);
                    r--;
                }
                if (nums[i] == 0) {
                    swap(nums, i, l);
                    l++;
                }
            }
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
    }

    public static void main(String[] args) {

    }
}
