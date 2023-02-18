import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfPairs {
    static class Solution {
        public int[] numberOfPairs(int[] nums) {
            int[] ans = new int[]{0, 0};
            Map<Integer, Integer> map = new HashMap<>();
            for (var num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (var entry : map.entrySet()) {
                int value = entry.getValue();
                ans[0] += value / 2;
                ans[1] += value % 2;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numberOfPairs(new int[]{1, 2, 3})));
    }
}
