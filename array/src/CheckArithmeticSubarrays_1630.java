import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays_1630 {
    static class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                ans.add(check(Arrays.copyOfRange(nums, l[i], r[i]+1)));
            }
            return ans;
        }

        private boolean check(int[] nums) {
            if (nums.length < 3) {
                return true;
            }
            Arrays.sort(nums);
            int s = nums[1] - nums[0];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] - nums[i - 1]!=s) {
                    return false;
                }
            }
            return true;
        }
    }
}
