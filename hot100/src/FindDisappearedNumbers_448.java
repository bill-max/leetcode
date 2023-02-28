import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers_448 {
    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                int idx = (nums[i] - 1) % n;
                nums[idx] += n;
            }
            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }
}
