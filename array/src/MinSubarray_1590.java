import java.util.HashMap;
import java.util.Map;

public class MinSubarray_1590 {
    static class Solution {
        public int minSubarray(int[] nums, int p) {
            int x = 0;
            //所有元素的和，与目标取模
            for (int num : nums) {
                x = (x + num) % p;
            }
            //如果所有元素的和与p整除，不需要删除子数组
            if (x == 0) {
                return 0;
            }
            //哈希表 key保存每个前缀的和与p的取模值，value表示是第几个元素的前缀
            //例如：value = 1 ， 表示nums[1]之前的所有元素之和 ， 子数组的长度就是 i - 1 + 1
            Map<Integer, Integer> index = new HashMap<Integer, Integer>();
            int y = 0, res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                index.put(y, i); // 存放 第i个元素的前缀和与p的取模值
                y = (y + nums[i]) % p; //第i个元素的前缀之和，与p取模
                // 如果第i个元素的前缀和与p的取模值 减去 所有元素之和与p的取模值 的差（+p是保持为正数，不影响操作数） % p 的值
                if (index.containsKey((y - x + p) % p)) {
                    //根据 y % p = x 那么 (y - z) % p = 0 等价于 z % p = x 定理
                    //(y - z) % p = x  等价于  z % p = (y - x) % p 定理
                    //(y - x + p) 相当于 剩余数组的和

                    //也就是说，剩余数组和 % p = 某个前缀和 % p ，根据定理可知
                    //取出剩余数组 与 前缀数组之间的子数组，所得到的数组和就能够被p整除（注意：子数组是连续的）
                    res = Math.min(res, i - index.get((y - x + p) % p) + 1); //获取最小值
                }
            }

            return res == nums.length ? -1 : res;
        }
    }
}
