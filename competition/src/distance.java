import java.util.*;

public class distance {
    class Solution {
        public long[] distance(int[] nums) {
            long[] ans = new long[nums.length];
            Map<Integer, long[]> pre = new HashMap<>();
            Map<Integer, long[]> last = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (pre.containsKey(nums[i])) {
                    long num = pre.get(nums[i])[0];
                    long cnt = pre.get(nums[i])[1];
                    ans[i] += (long) (cnt) * i - num;
                    pre.get(nums[i])[0] += i;
                    pre.get(nums[i])[1]++;
                } else
                    pre.put(nums[i], new long[]{i, 1});
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (last.containsKey(nums[i])) {
                    long num = last.get(nums[i])[0];
                    long cnt = last.get(nums[i])[1];
                    ans[i] += num - (long) (cnt) * i;
                    last.get(nums[i])[0] += i;
                    last.get(nums[i])[1]++;
                } else {
                    last.put(nums[i], new long[]{i, 1});
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new distance().new Solution().distance(new int[]{1, 3, 1, 1, 2})));
    }
}
