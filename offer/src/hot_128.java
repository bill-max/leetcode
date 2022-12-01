import java.util.HashSet;
import java.util.Set;

public class hot_128 {
    static class Solution {
        /**
         * 最长连续序列
         *
         * @param nums
         * @return
         */
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            Set<Integer> set = new HashSet<>();
            int ans = 1;
            for (int num : nums) set.add(num);
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int temp = 1;
                    while (set.contains(temp + num)) {
                        temp++;
                    }
                    ans = Math.max(ans, temp);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
    }
}
