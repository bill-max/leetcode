import java.util.Arrays;

public class maximizeGreatness {
    static class Solution {
        public int maximizeGreatness(int[] nums) {
            Arrays.sort(nums);
            int i = 0;
            for (int x : nums)
                if (x > nums[i])
                    ++i;
            return i;
        }
    }
}
