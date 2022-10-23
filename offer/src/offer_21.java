import java.util.Arrays;

public class offer_21 {
    static class Solution {
        public int[] exchange(int[] nums) {
            int p1 = 0, p2 = 0;
            for (int num : nums) {
                if (num % 2 == 1) {
                    p2++;
                }
            }
            while (p2 < nums.length && p1 < p2) {
                if (nums[p1] % 2 == 0 && nums[p2] % 2 == 1) {
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p1++;
                    p2++;
                } else if (nums[p1] % 2 == 0 && nums[p2] % 2 == 0) {
                    p2++;
                } else if (nums[p1] % 2 == 1 && nums[p2] % 2 == 1) {
                    p1++;
                } else {
                    p1++;
                    p2++;
                }
            }
            return nums;
        }

        /**
         * 从后往前原地交换
         * @param nums
         * @return
         */
        public int[] exchange2(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                while (left < right && nums[left] % 2 == 1) {
                    left++;
                }
                while (left < right && nums[right] % 2 == 0) {
                    right--;
                }
                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{8, 14, 0, 5, 16, 4, 10, 6, 1})));
    }
}
