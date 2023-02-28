import java.util.HashSet;
import java.util.Set;

public class MinimumOperations_2357 {
    static class Solution {
        public int minimumOperations(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (var num : nums) {
                if (num == 0) continue;
                set.add(num);
            }
            return set.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{1, 3, 5, 0, 5}));
    }
}