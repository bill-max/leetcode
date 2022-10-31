import java.util.HashMap;
import java.util.Map;

public class offer_39 {
    static class Solution {
        /**
         * 计数  HashMap  O(n) O(n)
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int count = map.getOrDefault(num, 0) + 1;
                if (count > nums.length / 2) {
                    return num;
                }
                map.put(num, count);
            }
            return -1;
        }

        /**
         * 优化  O(1)
         * 由于是找 大于一半个数的数，所以只需要维护最大值的个数和最大值
         * @param nums
         * @return
         */
        public int majorityElement2(int[] nums) {
            int curCount=1;
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i];
                if (max != cur && curCount == 1) max = cur;
                else if (max==cur) curCount++;
                else curCount--;
            }
            return max;
        }

    }
}
