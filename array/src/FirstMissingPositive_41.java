import java.util.*;

public class FirstMissingPositive_41 {
    static class Solution {
        /**
         * O(n)   O(n)
         */
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int i = 1; i <= nums.length; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return nums.length + 1;
        }

        //O(NlogN) O(1)
        public int firstMissingPositive2(int[] nums) {
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length && nums[i] <= 0) {
                i++;
            }
            int j = 1;
            int num = -1;
            while (i < nums.length && j <= nums.length) {
                if (nums[i] == num) {
                    i++;
                    continue;
                }
                num = nums[i++];
                if (j < num) {
                    return j;
                }
                j++;
            }
            return j;
        }

        //O(n) O(1)
        public int firstMissingPositive3(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            for (int i = 0; i < n; ++i) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive3(new int[]{1, 1}));
    }
}
