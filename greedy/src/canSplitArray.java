import java.util.ArrayList;
import java.util.List;

public class canSplitArray {
    static class Solution {
        public boolean canSplitArray(List<Integer> nums, int m) {
            if (nums.size() <= 2) return true;
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) + nums.get(i - 1) >= m) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canSplitArray(List.of(2, 3, 3, 2, 3), 6));
    }
}
