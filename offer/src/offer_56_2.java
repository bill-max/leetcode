import java.util.HashMap;
import java.util.Map;

public class offer_56_2 {
    static class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num:nums) map.put(num, map.getOrDefault(num, 0) + 1);
            for (int num : nums) {
                if (map.get(num) == 1) {
                    return num;
                }
            }
            return -1;
        }

        /**
         * 位运算
         * @param nums
         * @return
         */
        public int singleNumber2(int[] nums) {
            //获取每一位1的个数
            int[] counts = new int[32];
            for(int num : nums) {
                for(int j = 0; j < 32; j++) {
                    counts[j] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for(int i = 0; i < 32; i++) {
                res <<= 1;//恢复操作
                res |= counts[31 - i] % m;//对 m 取余
            }
            return res;
        }
    }
}
