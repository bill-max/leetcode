import java.util.HashMap;
import java.util.Map;

public class longestAlternatingSubarray {
    static class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1 || nums[i] > threshold) continue;
                int j = i;
                while (j < nums.length && nums[j] <= threshold && ((j - i) % 2 == nums[j] % 2)) {
                    j++;
                }
                res = Math.max(res, j - i);
                i = j - 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{4, 10, 3}, 4));
    }
}
