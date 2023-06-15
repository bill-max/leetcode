import java.util.HashSet;
import java.util.Set;

public class distinctDifferenceArray {
    static class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int[] pre = new int[nums.length];
            int[] last = new int[nums.length];
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
                pre[i] = set.size();
            }
            set.clear();
            for (int i = nums.length - 1; i >0; i--) {
                set.add(nums[i]);
                last[i - 1] = set.size();
            }
            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = pre[i] - last[i];
            }
            return res;
        }
    }
}
